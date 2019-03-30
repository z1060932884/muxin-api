package com.zzj.muxin.service;

import com.zzj.muxin.domain.Users;
import com.zzj.muxin.netty.ChatMsg;

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
    public Users queryUsername(String username,String password);

    /**
     * 注册用户 保存
     * @param users
     * @return
     */
    public Users saveUser(Users users);

    /**
     * 修改用户信息
     */
    public Users updateUserInfo(Users users);

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
}
