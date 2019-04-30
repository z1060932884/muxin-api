package com.zzj.muxin.controller;

import com.zzj.muxin.bo.GroupCreateModel;
import com.zzj.muxin.db.Group;
import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.service.GroupService;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.vo.GroupCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
        Group group = groupService.create(user,createModel,chatUsers);
        if(group == null){
            return IMoocJSONResult.errorMsg("服务器异常");
        }
        //拿到群成员，给所有群成员发送信息，已经被添加到群的信息
        GroupMember createrMember = groupService.getMember(user.getId(),group.getId());
        if(createrMember == null){
            return IMoocJSONResult.errorMsg("服务器异常");
        }
        Set<GroupMember> groupMembers = groupService.getMembers(group);
        return null;
    }
}
