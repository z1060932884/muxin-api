package com.zzj.muxin.serviceImp;

import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.*;
import com.zzj.muxin.mapper.TbGroupMapper;
import com.zzj.muxin.mapper.TbGroupMemberMapper;
import com.zzj.muxin.service.GroupService;
import org.assertj.core.util.Strings;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;


@Service
public class GroupServiceImp implements GroupService {

    @Autowired
    private TbGroupMapper groupMapper;
    @Autowired
    private TbGroupMemberMapper groupMemberMapper;

    @Autowired
    private Sid sid;

    /**
     * 通过名字查找群
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TbGroup findByName(String groupName) {
        TbGroupExample tbGroupExample = new TbGroupExample();
        TbGroupExample.Criteria criteria = tbGroupExample.createCriteria();
        criteria.andGroupNameEqualTo(groupName);
        List<TbGroup> groups = groupMapper.selectByExample(tbGroupExample);
        if(groups!=null&&groups.size()!=0){
            return groups.get(0);
        }
        return null;
    }

    @Override
    public TbGroup findById(String userId, String groupId) {
        TbGroupMember groupMember = getMember(userId,groupId);
        if(groupMember!=null){
            return findById(groupId);
        }
        return null;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TbGroup findById(String groupId) {
        TbGroupExample tbGroupExample = new TbGroupExample();
        TbGroupExample.Criteria criteria = tbGroupExample.createCriteria();
        criteria.andIdEqualTo(groupId);
        List<TbGroup> groups = groupMapper.selectByExample(tbGroupExample);
        if(groups!=null&&groups.size()!=0){
            return groups.get(0);
        }
        return null;
    }
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TbGroup create(ChatUsers user, GroupCreateModel createModel, List<ChatUsers> chatUsers) {
        TbGroup group = new TbGroup();
        group.setOwnerId(user.getId());
        group.setDescription(createModel.getDesc());
        group.setPicture(createModel.getPicture());
        group.setGroupName(createModel.getName());
        group.setId(sid.nextShort());
        groupMapper.insert(group);

        TbGroupMember groupMember = new TbGroupMember();
        groupMember.setUserid(user.getId());
        groupMember.setGroupid(group.getId());
        groupMember.setId(sid.nextShort());
        //设置超级权限
        groupMember.setPermissiontype(GroupMember.PERMISSION_TYPE_ADMIN_SU);
        groupMemberMapper.insert(groupMember);
        //循环添加普通成员
        chatUsers.forEach(chatUsers1 -> {
            TbGroupMember tbGroupMember = new TbGroupMember();
            tbGroupMember.setUserid(chatUsers1.getId());
            tbGroupMember.setGroupid(group.getId());
            tbGroupMember.setId(sid.nextShort());
            tbGroupMember.setPermissiontype(GroupMember.PERMISSION_TYPE_NONE);
            groupMemberMapper.insert(tbGroupMember);
        });

        return group;
    }

    /**
     * 获取一个群的成员
     * @param userId
     * @param groupId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public TbGroupMember getMember(String userId, String groupId) {
        TbGroupMemberExample groupMemberExample = new TbGroupMemberExample();
        TbGroupMemberExample.Criteria criteria = groupMemberExample.createCriteria();
        criteria.andGroupidEqualTo(groupId);
        criteria.andUseridEqualTo(userId);
        List<TbGroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        if(groupMembers!=null&& groupMembers.size()!=0){
            return groupMembers.get(0);
        }
        return null;
    }

    /**
     * 获取群的成员
     * @param group
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Set<TbGroupMember> getMembers(TbGroup group) {
        TbGroupMemberExample groupMemberExample = new TbGroupMemberExample();
        TbGroupMemberExample.Criteria criteria = groupMemberExample.createCriteria();
        criteria.andGroupidEqualTo(group.getId());
        List<TbGroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        return new HashSet<>(groupMembers);
    }
    /**
     * 获取群的成员
     * @param groupId
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Set<TbGroupMember> getMembersByGroupId(String groupId) {
        TbGroupMemberExample groupMemberExample = new TbGroupMemberExample();
        TbGroupMemberExample.Criteria criteria = groupMemberExample.createCriteria();
        criteria.andGroupidEqualTo(groupId);
        List<TbGroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);
        return new HashSet<>(groupMembers);
    }

    @Override
    public Set<TbGroupMember> getMembers(String userId) {
        TbGroupMemberExample groupMemberExample = new TbGroupMemberExample();
        TbGroupMemberExample.Criteria criteria = groupMemberExample.createCriteria();
        criteria.andUseridEqualTo(userId);
        List<TbGroupMember> groupMembers = groupMemberMapper.selectByExample(groupMemberExample);


        return new HashSet<>(groupMembers);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<TbGroup> search(String name) {
        if(Strings.isNullOrEmpty(name)){
            name = "";
        }
        String searchName = "%"+name+"%";//模糊匹配
        TbGroupExample tbGroupExample = new TbGroupExample();
        TbGroupExample.Criteria criteria = tbGroupExample.createCriteria();
        criteria.andGroupNameLike(searchName);


        return groupMapper.selectByExample(tbGroupExample);
    }

    /**
     * 添加群成员
     * @param group
     * @param insertUsers
     * @return
     */
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Set<TbGroupMember> addMembers(TbGroup group, List<ChatUsers> insertUsers) {
        Set<TbGroupMember> tbGroupMembers = new HashSet<>();
        //循环添加普通成员
        insertUsers.forEach(chatUsers1 -> {
            TbGroupMember tbGroupMember = new TbGroupMember();
            tbGroupMember.setUserid(chatUsers1.getId());
            tbGroupMember.setGroupid(group.getId());
            tbGroupMember.setId(sid.nextShort());
            tbGroupMember.setPermissiontype(GroupMember.PERMISSION_TYPE_NONE);
            groupMemberMapper.insert(tbGroupMember);
            tbGroupMembers.add(tbGroupMember);
        });
        return tbGroupMembers;
    }
}
