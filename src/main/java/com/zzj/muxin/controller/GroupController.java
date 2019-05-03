package com.zzj.muxin.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.bo.GroupMemberAddModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.domain.TbGroup;
import com.zzj.muxin.domain.TbGroupMember;
import com.zzj.muxin.factory.PushFactory;
import com.zzj.muxin.service.GroupService;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.vo.GroupCard;
import com.zzj.muxin.vo.GroupMemberCard;
import org.assertj.core.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @desc 群组控制器
 */

@RestController
@RequestMapping("group")
public class GroupController {
    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @Autowired
    private GroupService groupService;
    /**
     * 创建群
     * @return
     */
    @PostMapping("/createGroup")
    public IMoocJSONResult createGroup(@RequestBody GroupCreateModel createModel){
        if(GroupCreateModel.check(createModel)){

            return IMoocJSONResult.errorMsg("参数错误");
        }
        //创建者
        ChatUsers user = userService.queryUserInfoByUserId(createModel.getUserid());
        //创建者并不在列表中
        createModel.getUsers().remove(user.getId());
        if(createModel.getUsers().size() == 0){
            return IMoocJSONResult.errorMsg("参数错误");
        }
        //检查群组名是否已经存在
        if(groupService.findByName(createModel.getName())!=null){

            return IMoocJSONResult.errorMsg("群组的名字已经存在");
        }
        List<ChatUsers> chatUsers = new ArrayList<>();
        for(String s: createModel.getUsers()){
            ChatUsers users = userService.queryUserInfoByUserId(s);
            if(users == null){
                continue;
            }
            chatUsers.add(users);

        }

        if(chatUsers.size() == 0){
            return IMoocJSONResult.errorMsg("参数错误，没有一个成员");
        }
        //创建群
        TbGroup group = groupService.create(user,createModel,chatUsers);
        if(group == null){
            return IMoocJSONResult.errorMsg("服务器异常");
        }
        //拿到群成员，给所有群成员发送信息，已经被添加到群的信息
        TbGroupMember createrMember = groupService.getMember(user.getId(),group.getId());
        if(createrMember == null){
            return IMoocJSONResult.errorMsg("服务器异常");
        }
        //拿到群成员给所有群成员发送消息，已经被添加到群里的消息
        Set<TbGroupMember> groupMembers = groupService.getMembers(group);
        if(groupMembers == null){
            //服务器异常
            return IMoocJSONResult.errorMsg("服务器异常");

        }
        groupMembers = groupMembers.stream()
                .filter(groupMember -> !groupMember.getId().equalsIgnoreCase(user.getId()))
                .collect(Collectors.toSet());
        //发送通知
        PushFactory.pushGroupAdd(groupMembers);


        return IMoocJSONResult.ok(new GroupCard(group,createrMember));
    }

    /**
     * 搜索群接口
     * @param userId
     * @param name
     * @return
     */
    @GetMapping("/search/{userId}/{name:(.*)?}")
    public IMoocJSONResult search(@PathVariable("userId") String userId,@PathVariable("name") String name){
//        ChatUsers chatUsers = userService.queryUserInfoByUserId(userId);
        List<TbGroup> groups = groupService.search(name);
        if(groups!=null && groups.size()!=0){
            List<GroupCard> groupCards = groups.stream().map(tbGroup -> {
               TbGroupMember groupMember= groupService.getMember(userId,tbGroup.getId());
               return new GroupCard(tbGroup,groupMember);
            }).collect(Collectors.toList());
            return IMoocJSONResult.ok(groupCards);
        }
        return IMoocJSONResult.ok();
    }

    /**
     * 获取群列表
     * @return
     */
    @GetMapping("list/{userId}/{date:(.*)?}")
    public IMoocJSONResult groupList(@PathVariable("userId")String userId,@PathVariable("date")String dateStr){
        Date date = null;
        try {
            //获取日期
            date = DateUtil.parse(dateStr);
        }catch (Exception e){
            e.printStackTrace();
            date = null;
        }
        Set<TbGroupMember> groupMembers = groupService.getMembers(userId);
        if(groupMembers == null || groupMembers.size() == 0){
            return IMoocJSONResult.ok();
        }
        Date finalDate = date;
        List<GroupCard> groupCards = groupMembers.stream()
                .filter(tbGroupMember -> finalDate == null //时间如果为null 不做限制
                    || tbGroupMember.getUpdateAt().after(finalDate)
                ).map(tbGroupMember -> {//转换操作
                    TbGroup tbGroup = groupService.findById(tbGroupMember.getGroupId());
                    return new GroupCard(tbGroup,tbGroupMember);

                }).collect(Collectors.toList());


        return IMoocJSONResult.ok(groupCards);
    }


    /**
     * 拉取群的信息  你必须是群的成员
     * @param groupId
     * @param userId
     * @return
     */
    @GetMapping("/{groupId}/{userId}")
    public IMoocJSONResult getGroupInfo(@PathVariable("groupId")String groupId,@PathVariable("userId")String userId){

        if(Strings.isNullOrEmpty(groupId)||Strings.isNullOrEmpty(userId)){
            return IMoocJSONResult.errorMsg("参数错误");
        }
        TbGroupMember groupMember = groupService.getMember(userId,groupId);

        TbGroup tbGroup = groupService.findById(groupMember.getGroupId());

        if(groupMember == null){
            return IMoocJSONResult.errorMsg("没有查找到群信息");
        }

        return IMoocJSONResult.ok(new GroupCard(tbGroup,groupMember));


    }


    /**
     * 获取群成员
     * @param userId
     * @param groupId
     * @return
     */
    @GetMapping("/getGroupMembers")
    public IMoocJSONResult getGroupMembers(String userId,String groupId){

        TbGroup group = groupService.findById(groupId);
        if(group == null){
            return IMoocJSONResult.errorMsg("没有查找到此群");
        }
        //检测权限
        TbGroupMember groupMember = groupService.getMember(userId,groupId);
        if(groupMember == null){
            return IMoocJSONResult.errorMsg("您没有查看群成员的权限");
        }
        //获取群成员
        Set<TbGroupMember> groupMemberSet = groupService.getMembers(group);

        if(groupMemberSet == null){
            return IMoocJSONResult.errorMsg("服务器错误");
        }
        //抓换数据
        List<GroupMemberCard> groupMemberCards = groupMemberSet.stream().map(GroupMemberCard::new).collect(Collectors.toList());
        return IMoocJSONResult.ok(groupMemberCards);
    }

    @PostMapping("addGroupMember")
    public IMoocJSONResult addGroupMember(String userId,String groupId,@RequestBody GroupMemberAddModel addModel){
        //权限校验
        if(!GroupMemberAddModel.check(addModel)){
            return IMoocJSONResult.errorMsg("参数错误");
        }
        ChatUsers users = userService.queryUserInfoByUserId(userId);
        addModel.getUsers().remove(userId);
        if(addModel.getUsers().size() == 0){
            return IMoocJSONResult.errorMsg("参数错误");
        }

        TbGroup group = groupService.findById(groupId);
        if(group == null){
            return IMoocJSONResult.errorMsg("没有此群");
        }

        //我必须是成员
        TbGroupMember groupMember = groupService.getMember(userId,groupId);
        if(groupMember == null || groupMember.getPermissionType() == GroupMember.PERMISSION_TYPE_NONE){
            return IMoocJSONResult.errorMsg("您没有操作权限");
        }
        //执行插入操作//首先拿去现在成员，比较如果已经存在 提示已加入  没有 插入
        //已有成员
        Set<TbGroupMember> oldMember = groupService.getMembers(group);
        Set<String> oldMemberUsers = oldMember.stream().map(TbGroupMember::getId).collect(Collectors.toSet());
        //这是要添加的用户
        List<ChatUsers> insertUsers = new ArrayList<>();
        for(String s: addModel.getUsers()){
            //找人
            ChatUsers addUser = userService.queryUserInfoByUserId(s);
            //如果没空 跳过
            if(addUser == null){
                continue;
            }
            //如果群里已经有成员  跳过
            if(oldMemberUsers.contains(addUser.getId())){
                continue;
            }

            insertUsers.add(users);

        }

        //没有新增的成员
        if(insertUsers.size() == 0){
            return IMoocJSONResult.errorMsg("参数错误，没有新增的成员");
        }
        //添加群成员
        Set<TbGroupMember> insertMembers = groupService.addMembers(group,insertUsers);
        if(insertMembers == null || insertMembers.size() == 0){
            return IMoocJSONResult.errorMsg("服务器错误");
        }
        //转换
        List<GroupMemberCard> insertCards = insertMembers.stream().map(GroupMemberCard::new).collect(Collectors.toList());

        //通知，两部曲
        //1、通知新增成员 你被加入xxx群
        PushFactory.pushJoinGroup(insertMembers);
        //2、通知群中老成员 有xxx，xxx加入了群
        PushFactory.pushGroupMemberAdd(oldMember,insertCards);

        return IMoocJSONResult.ok(insertCards);
    }
}
