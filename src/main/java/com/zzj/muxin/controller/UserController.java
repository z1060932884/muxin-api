package com.zzj.muxin.controller;

import com.zzj.muxin.bo.UsersBo;
import com.zzj.muxin.domain.ChatMsg;
import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.enums.OperatorFriendRequestTypeEnum;
import com.zzj.muxin.enums.SearchFriendsStatusEnum;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.FastDFSClient;
import com.zzj.muxin.utils.FileUtils;
import com.zzj.muxin.utils.IMoocJSONResult;
import com.zzj.muxin.utils.MD5Utils;
import com.zzj.muxin.vo.MyFriendsVO;
import com.zzj.muxin.vo.UsersVO;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("u")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FastDFSClient fastDFSClient;

    @PostMapping("/registerOrLogin")
    public IMoocJSONResult registerOrLogin(@RequestBody ChatUsers users) throws Exception{

        if(Strings.isBlank(users.getUsername() )|| Strings.isBlank(users.getPassword())){

            return IMoocJSONResult.errorMsg("用户名或密码不能为空");
        }

        ChatUsers usersResult = null;
        //判断用户名是否存在，如果存在就登录，如果不存在则注册
        boolean usernameIsExist = userService.queryUsernameIsExist(users.getUsername());
        if(usernameIsExist){
            //登录
            usersResult = userService.queryUsername(users.getUsername(), MD5Utils.getMD5Str(users.getPassword()));
            if(usersResult == null){
                return IMoocJSONResult.errorMsg("用户名或密码不能为空");
            }

        }else {
            //注册

            users.setNickname(users.getUsername());
            users.setFaceImage("");
            users.setFaceImageBig("");
            users.setPassword(MD5Utils.getMD5Str(users.getPassword()));
            usersResult = userService.saveUser(users);

        }

        return IMoocJSONResult.ok(usersResult);
    }
    @PostMapping("/updateUserInfo")
    public IMoocJSONResult updateUserInfo(@RequestBody ChatUsers users) throws Exception{

        if(Strings.isBlank(users.getId() )|| Strings.isBlank(users.getFaceImage())
                ||Strings.isBlank(users.getNickname()) ||Strings.isBlank(users.getDescription())
                ||users.getChatSex()==0){

            return IMoocJSONResult.errorMsg("信息不能为空");
        }

        //判断用户名是否存在，
        ChatUsers chatUsers = userService.queryUserInfoByUserId(users.getId());
        if(chatUsers == null){
            return IMoocJSONResult.errorMsg("用户信息错误");
        }
        chatUsers.setFaceImage(users.getFaceImage());
        chatUsers.setNickname(users.getNickname());
        chatUsers.setDescription(users.getDescription());
        chatUsers.setChatSex(users.getChatSex());

        return IMoocJSONResult.ok(userService.updateUserInfo(chatUsers));
    }

    @PostMapping("/uploadFace")
    private IMoocJSONResult uploadFaceBase64(@RequestBody UsersBo usersBo) throws Exception{

        //获取前端传过来的base64字符串，然后转换成文件对象再上传
        String base64Image = usersBo.getFaceData();
        String userFacePath = "D:\\"+ usersBo.getUserId()+"userFace64.png";
//        String userFacePath = "/fastdfs/tmp/"+ usersBo.getUserId()+"userFace64.png";

        FileUtils.base64ToFile(userFacePath,base64Image);
        //上传文件到fastdfs
        MultipartFile file = FileUtils.fileToMultipart(userFacePath);

        String url = fastDFSClient.uploadBase64(file);
        System.out.println(url);

        //获取缩略图的url
        String thump = "_80x80.";
        String arr[]  = url.split("\\.");
        String thumpImageUrl = arr[0] + thump+arr[1];

        //更改用户头像
        ChatUsers users = userService.queryUserInfoByUserId(usersBo.getUserId());
        users.setId(usersBo.getUserId());
        users.setFaceImageBig(url);
        users.setFaceImage(thumpImageUrl);

        return IMoocJSONResult.ok(userService.updateUserInfo(users));
    }

    /**
     * @Description: 搜索好友接口, 根据账号做匹配查询而不是模糊查询
     */
    @PostMapping("/search")
    public IMoocJSONResult searchUser(String myUserId, String friendUsername)
            throws Exception {

        // 0. 判断 myUserId friendUsername 不能为空
        if (StringUtils.isBlank(myUserId)
                || StringUtils.isBlank(friendUsername)) {
            return IMoocJSONResult.errorMsg("");
        }

        // 前置条件 - 1. 搜索的用户如果不存在，返回[无此用户]
        // 前置条件 - 2. 搜索账号是你自己，返回[不能添加自己]
        // 前置条件 - 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
        Integer status = userService.preconditionSearchFriends(myUserId, friendUsername);
        if (status == SearchFriendsStatusEnum.SUCCESS.status) {
            ChatUsers user = userService.queryUserInfoByUsername(friendUsername);
            UsersVO userVO = new UsersVO();
            BeanUtils.copyProperties(user, userVO);
            return IMoocJSONResult.ok(userVO);
        } else {
            String errorMsg = SearchFriendsStatusEnum.getMsgByKey(status);
            return IMoocJSONResult.errorMsg(errorMsg);
        }
    }

    /**
     * @Description: 发送添加好友的请求
     */
    @PostMapping("/addFriendRequest")
    public IMoocJSONResult addFriendRequest(String myUserId, String friendUsername)
            throws Exception {

        // 0. 判断 myUserId friendUsername 不能为空
        if (StringUtils.isBlank(myUserId)
                || StringUtils.isBlank(friendUsername)) {
            return IMoocJSONResult.errorMsg("");
        }

        // 前置条件 - 1. 搜索的用户如果不存在，返回[无此用户]
        // 前置条件 - 2. 搜索账号是你自己，返回[不能添加自己]
        // 前置条件 - 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
        Integer status = userService.preconditionSearchFriends(myUserId, friendUsername);
        if (status == SearchFriendsStatusEnum.SUCCESS.status) {
            userService.sendFriendRequest(myUserId, friendUsername);
        } else {
            String errorMsg = SearchFriendsStatusEnum.getMsgByKey(status);
            return IMoocJSONResult.errorMsg(errorMsg);
        }

        return IMoocJSONResult.ok();
    }

    /**
     * @Description: 发送添加好友的请求
     */
    @PostMapping("/queryFriendRequests")
    public IMoocJSONResult queryFriendRequests(String userId) {

        // 0. 判断不能为空
        if (StringUtils.isBlank(userId)) {
            return IMoocJSONResult.errorMsg("");
        }

        // 1. 查询用户接受到的朋友申请
        return IMoocJSONResult.ok(userService.queryFriendRequestList(userId));
    }


    /**
     * @Description: 接受方 通过或者忽略朋友请求
     */
    @PostMapping("/operFriendRequest")
    public IMoocJSONResult operFriendRequest(String acceptUserId, String sendUserId,
                                             Integer operType) {

        // 0. acceptUserId sendUserId operType 判断不能为空
        if (StringUtils.isBlank(acceptUserId)
                || StringUtils.isBlank(sendUserId)
                || operType == null) {
            return IMoocJSONResult.errorMsg("");
        }

        // 1. 如果operType 没有对应的枚举值，则直接抛出空错误信息
        if (StringUtils.isBlank(OperatorFriendRequestTypeEnum.getMsgByType(operType))) {
            return IMoocJSONResult.errorMsg("");
        }

        if (operType == OperatorFriendRequestTypeEnum.IGNORE.type) {
            // 2. 判断如果忽略好友请求，则直接删除好友请求的数据库表记录
            userService.deleteFriendRequest(sendUserId, acceptUserId);
        } else if (operType == OperatorFriendRequestTypeEnum.PASS.type) {
            // 3. 判断如果是通过好友请求，则互相增加好友记录到数据库对应的表
            //	   然后删除好友请求的数据库表记录
            userService.passFriendRequest(sendUserId, acceptUserId);
        }

        // 4. 数据库查询好友列表
        List<MyFriendsVO> myFirends = userService.queryMyFriends(acceptUserId);

        return IMoocJSONResult.ok(myFirends);
    }

    /**
     * @Description: 查询我的好友列表
     */
    @PostMapping("/myFriends")
    public IMoocJSONResult myFriends(String userId) {
        // 0. userId 判断不能为空
        if (StringUtils.isBlank(userId)) {
            return IMoocJSONResult.errorMsg("");
        }

        // 1. 数据库查询好友列表
        List<MyFriendsVO> myFirends = userService.queryMyFriends(userId);

        return IMoocJSONResult.ok(myFirends);
    }


    /**
     * 根据id获取用户信息
     * @param userId 用户id
     * @return
     */
    @GetMapping("/getUserInfo")
    public IMoocJSONResult getUserInfo(String userId){
        // 0. userId 判断不能为空
        if (StringUtils.isBlank(userId)) {
            return IMoocJSONResult.errorMsg("");
        }

       ChatUsers users =  userService.queryUserInfoByUserId(userId);
        if(users == null){
            return IMoocJSONResult.errorMsg("该用户不存在");
        }
        return IMoocJSONResult.ok(users);
    }


    /**
     *
     * @Description: 用户手机端获取未签收的消息列表
     */
    @PostMapping("/getUnReadMsgList")
    public IMoocJSONResult getUnReadMsgList(String acceptUserId) {
        // 0. userId 判断不能为空
        if (StringUtils.isBlank(acceptUserId)) {
            return IMoocJSONResult.errorMsg("");
        }

        // 查询列表
        List<ChatMsg> unreadMsgList = userService.getUnReadMsgList(acceptUserId);

        return IMoocJSONResult.ok(unreadMsgList);
    }
}
