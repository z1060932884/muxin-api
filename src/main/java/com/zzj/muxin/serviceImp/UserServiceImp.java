package com.zzj.muxin.serviceImp;

import com.zzj.muxin.domain.*;
import com.zzj.muxin.enums.MsgActionEnum;
import com.zzj.muxin.enums.MsgSignFlagEnum;
import com.zzj.muxin.enums.SearchFriendsStatusEnum;
import com.zzj.muxin.mapper.ChatMsgMapper;
import com.zzj.muxin.mapper.FriendsRequestMapper;
import com.zzj.muxin.mapper.MyFriendsMapper;
import com.zzj.muxin.mapper.UsersMapper;
import com.zzj.muxin.netty.ChatMsg;
import com.zzj.muxin.netty.DataContent;
import com.zzj.muxin.netty.UserChannelRel;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.JsonUtils;
import com.zzj.muxin.vo.FriendRequestVO;
import com.zzj.muxin.vo.MyFriendsVO;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.n3r.idworker.Sid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.netty.channel.Channel;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class UserServiceImp implements UserService {

    /**
     * 使用编译的mapper自动注入
     */
    @Autowired
    private UsersMapper usersMapper;

    @Autowired
    private MyFriendsMapper myFriendsMapper;

    @Autowired
    private FriendsRequestMapper friendsRequestMapper;


    @Autowired
    private ChatMsgMapper msgMapper;

    @Autowired
    private Sid sid;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public boolean queryUsernameIsExist(String username) {

        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> users = usersMapper.selectByExample(example);

        if(users.size()>0){
            System.out.println(users.size());
            return true;
        }

        return false;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUsername(String username, String password) {
        Users users = null;
        UsersExample example = new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<Users> usersList = usersMapper.selectByExample(example);
        if(usersList.size()>0){
            users = usersList.get(0);
        }
        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users saveUser(Users users) {

        // TODO: 2018/11/2 为用户生成一个二维码
        users.setQrcode("");

        users.setId(sid.nextShort());

        usersMapper.insert(users);

        return users;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Users updateUserInfo(Users users) {
        usersMapper.updateByPrimaryKeySelective(users);
        return queryUserById(users.getId());
    }


    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Integer preconditionSearchFriends(String myUserId, String friendUsername) {

        Users user = queryUserInfoByUsername(friendUsername);

        // 1. 搜索的用户如果不存在，返回[无此用户]
        if (user == null) {
            return SearchFriendsStatusEnum.USER_NOT_EXIST.status;
        }

        // 2. 搜索账号是你自己，返回[不能添加自己]
        if (user.getId().equals(myUserId)) {
            return SearchFriendsStatusEnum.NOT_YOURSELF.status;
        }

        // 3. 搜索的朋友已经是你的好友，返回[该用户已经是你的好友]
        MyFriendsExample mfe = new MyFriendsExample();
        MyFriendsExample.Criteria mfc = mfe.createCriteria();
        mfc.andMyUserIdEqualTo( myUserId);
        mfc.andMyFriendUserIdEqualTo( user.getId());
        MyFriends myFriendsRel = null;
        List<MyFriends> myFriendsList = myFriendsMapper.selectByExample(mfe);
        if(myFriendsList!=null&&myFriendsList.size()>0){
            myFriendsRel = myFriendsList.get(0);
        }
        if (myFriendsRel != null) {
            return SearchFriendsStatusEnum.ALREADY_FRIENDS.status;
        }

        return SearchFriendsStatusEnum.SUCCESS.status;
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Users queryUserInfoByUsername(String username) {
        UsersExample ue = new UsersExample();
        UsersExample.Criteria uc = ue.createCriteria();
        uc.andUsernameEqualTo( username);
        Users users = null;
        List<Users> usersList = usersMapper.selectByExample(ue);
        if(usersList!=null&&usersList.size()>0){
            users = usersList.get(0);
        }
        return users;
    }


    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void sendFriendRequest(String myUserId, String friendUsername) {

        // 根据用户名把朋友信息查询出来
        Users friend = queryUserInfoByUsername(friendUsername);

        // 1. 查询发送好友请求记录表
        FriendsRequestExample fre = new FriendsRequestExample();
        FriendsRequestExample.Criteria frc = fre.createCriteria();
        frc.andSendUserIdEqualTo(myUserId);
        frc.andAcceptUserIdEqualTo(friend.getId());
        List<FriendsRequest> friendRequests = friendsRequestMapper.selectByExample(fre);
        if(friendRequests == null || friendRequests.size() == 0 ){
            // 2. 如果不是你的好友，并且好友记录没有添加，则新增好友请求记录
            String requestId = sid.nextShort();

            FriendsRequest request = new FriendsRequest();
            request.setId(requestId);
            request.setSendUserId(myUserId);
            request.setAcceptUserId(friend.getId());
            request.setRequestDateTime(new Date());
            friendsRequestMapper.insert(request);
        }

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<FriendRequestVO> queryFriendRequestList(String acceptUserId) {
        List<FriendRequestVO> friendRequestVOS = new ArrayList<>();
        // 1. 查询发送好友请求记录表
        FriendsRequestExample fre = new FriendsRequestExample();
        FriendsRequestExample.Criteria frc = fre.createCriteria();
        frc.andAcceptUserIdEqualTo(acceptUserId);
        List<FriendsRequest> friendsRequests = friendsRequestMapper.selectByExample(fre);
        if(friendsRequests!=null && friendsRequests.size()>0){
            for(FriendsRequest friendsRequest : friendsRequests){
                FriendRequestVO friendRequestVO = new FriendRequestVO();
                BeanUtils.copyProperties(friendsRequest,friendRequestVO);
                friendRequestVOS.add(friendRequestVO);
            }
        }
        return friendRequestVOS;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void deleteFriendRequest(String sendUserId, String acceptUserId) {
        FriendsRequestExample fre = new FriendsRequestExample();
        FriendsRequestExample.Criteria frc = fre.createCriteria();
        frc.andSendUserIdEqualTo(sendUserId);
        frc.andAcceptUserIdEqualTo( acceptUserId);
        friendsRequestMapper.deleteByExample(fre);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void passFriendRequest(String sendUserId, String acceptUserId) {
        saveFriends(sendUserId, acceptUserId);
        saveFriends(acceptUserId, sendUserId);
        deleteFriendRequest(sendUserId, acceptUserId);

        Channel sendChannel = UserChannelRel.get(sendUserId);
        if (sendChannel != null) {
            // 使用websocket主动推送消息到请求发起者，更新他的通讯录列表为最新
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.PULL_FRIEND.type);

            sendChannel.writeAndFlush(
                    new TextWebSocketFrame(
                            JsonUtils.objectToJson(dataContent)));
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void saveFriends(String sendUserId, String acceptUserId) {
        MyFriends myFriends = new MyFriends();
        String recordId = sid.nextShort();
        myFriends.setId(recordId);
        myFriends.setMyFriendUserId(acceptUserId);
        myFriends.setMyUserId(sendUserId);
        myFriendsMapper.insert(myFriends);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public List<MyFriendsVO> queryMyFriends(String userId) {
        List<MyFriendsVO> myFriendsVOS = new ArrayList<>();
        MyFriendsExample myFriendsExample = new MyFriendsExample();
        MyFriendsExample.Criteria criteria = myFriendsExample.createCriteria();
        criteria.andMyUserIdEqualTo(userId);
        List<MyFriends> myFirends = myFriendsMapper.selectByExample(myFriendsExample);
        if(myFirends!=null && myFirends.size()>0){
            for(MyFriends myFriends : myFirends){
                MyFriendsVO myFriendsVO = new MyFriendsVO();
                BeanUtils.copyProperties(myFriends,myFriendsVO);
                myFriendsVOS.add(myFriendsVO);
            }
        }
        return myFriendsVOS;
    }


    @Override
    public String saveMsg(ChatMsg chatMsg) {
        com.zzj.muxin.domain.ChatMsg msg = new com.zzj.muxin.domain.ChatMsg();
        String msgId = sid.nextShort();
        msg.setId(msgId);
        msg.setMsg(chatMsg.getMsg());
        msg.setAcceptUserId(chatMsg.getReceiverId());
        msg.setSendUserId(chatMsg.getSenderId());
        msg.setCreateTime(new Date());
        msg.setSignFlag(MsgSignFlagEnum.unsign.type);

        msgMapper.insert(msg);

        return msgId;
    }

    @Override
    public void updateMsgSigned(List<String> msgIdList) {
        ChatMsgExample chatMsgExample = new ChatMsgExample();
        ChatMsgExample.Criteria criteria = chatMsgExample.createCriteria();
        criteria.andIdIn(msgIdList);
        com.zzj.muxin.domain.ChatMsg chatMsg = new com.zzj.muxin.domain.ChatMsg();
        chatMsg.setSignFlag(MsgSignFlagEnum.signed.type);
        msgMapper.updateByExample(chatMsg,chatMsgExample);
    }


    private Users queryUserById(String userId){

        return usersMapper.selectByPrimaryKey(userId);
    }

}
