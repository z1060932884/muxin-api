package com.zzj.muxin.service;

import com.zzj.muxin.domain.ChatUsers;
import com.zzj.muxin.netty.ChatMsg;
import com.zzj.muxin.vo.FriendRequestVO;
import com.zzj.muxin.vo.MyFriendsVO;

import java.util.List;

public interface UserService {

    /**
     * 判断用户名是否存在
     * @param username 用户名
     * @return
     */
    public boolean queryUsernameIsExist(String username);

    /**
     * 查询用户
     * @param username
     * @param password
     * @return
     */
    public ChatUsers queryUsername(String username, String password);

    /**
     * 注册用户 保存
     * @param users
     * @return
     */
    public ChatUsers saveUser(ChatUsers users);

    /**
     * 修改用户信息
     */
    public ChatUsers updateUserInfo(ChatUsers users);

    /**
     * 保存消息
     * @param chatMsg
     * @return 消息id
     */
    public String saveMsg (ChatMsg chatMsg);

    /**
     * 更新消息的签收状态
     * @param msgIdList
     */
    void updateMsgSigned(List<String> msgIdList);

    /**
     * @Description: 搜索朋友的前置条件
     */
    public Integer preconditionSearchFriends(String myUserId, String friendUsername);

    /**
     * @Description: 根据用户名查询用户对象
     */
    public ChatUsers queryUserInfoByUsername(String username);
    /**
     * @Description: 根据id查询用户对象
     */
    public ChatUsers queryUserInfoByUserId(String userId);

    /**
     * @Description: 添加好友请求记录，保存到数据库
     */
    public void sendFriendRequest(String myUserId, String friendUsername);

    /**
     * @Description: 查询好友请求
     */
    public List<FriendRequestVO> queryFriendRequestList(String acceptUserId);

    /**
     * @Description: 删除好友请求记录
     */
    public void deleteFriendRequest(String sendUserId, String acceptUserId);

    /**
     * @Description: 通过好友请求
     * 				1. 保存好友
     * 				2. 逆向保存好友
     * 				3. 删除好友请求记录
     */
    public void passFriendRequest(String sendUserId, String acceptUserId);

    /**
     * @Description: 查询好友列表
     */
    public List<MyFriendsVO> queryMyFriends(String userId);


    /**
     * @Description: 获取未签收消息列表
     */
    public List<com.zzj.muxin.domain.ChatMsg> getUnReadMsgList(String acceptUserId);

}
