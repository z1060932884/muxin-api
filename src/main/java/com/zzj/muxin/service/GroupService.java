package com.zzj.muxin.service;


import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.domain.TbGroup;
import com.zzj.muxin.domain.TbGroupMember;

import java.util.List;
import java.util.Set;

public interface GroupService {

    /**
     * 查找群
     * @param groupName
     * @return
     */
    public TbGroup findByName(String groupName);
    /**
     * 查找群 同时这个人必须是群的成员
     * @param groupId
     * @return
     */
    public TbGroup findById(String userId,String groupId);

    public TbGroup findById(String groupId);

    TbGroup create(ChatUsers user, GroupCreateModel createModel, List<ChatUsers> chatUsers);

    TbGroupMember getMember(String userId, String groupId);

    Set<TbGroupMember> getMembers(TbGroup group);
    Set<TbGroupMember> getMembersByGroupId(String groupId);
    Set<TbGroupMember> getMembers(String  userId);


    /**
     * 搜索群
     * @param name
     * @return
     */
    List<TbGroup> search(String name);

    /**
     * 添加群成员
     * @param group
     * @param insertUsers
     * @return
     */
    Set<TbGroupMember> addMembers(TbGroup group, List<ChatUsers> insertUsers);
}
