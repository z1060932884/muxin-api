package com.zzj.muxin.factory;

import com.zzj.muxin.db.GroupMember;
import com.zzj.muxin.domain.TbGroupMember;
import com.zzj.muxin.enums.MsgActionEnum;
import com.zzj.muxin.netty.ChatMsg;
import com.zzj.muxin.netty.DataContent;
import com.zzj.muxin.netty.UserChannelRel;
import com.zzj.muxin.service.GroupService;
import com.zzj.muxin.service.UserService;
import com.zzj.muxin.utils.JsonUtils;
import com.zzj.muxin.utils.SpringUtil;
import com.zzj.muxin.vo.GroupMemberCard;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 推送工具
 */
public class PushFactory {




    /**
     * 推送添加群的通知
     * @param groupMembers 群成员
     */
    public static void pushGroupAdd(Set<TbGroupMember> groupMembers) {

    }

    /**
     * 通知新成员  您加入了xxx群
     * @param insertMembers 新增成员集合
     */
    public static void pushJoinGroup(Set<TbGroupMember> insertMembers) {
    }

    /**
     * 通知老成员   xxx，xxx加入了群
     * @param oldMember 老的成员
     * @param insertCards 新成员信息
     */
    public static void pushGroupMemberAdd(Set<TbGroupMember> oldMember, List<GroupMemberCard> insertCards) {
    }

    /**
     * 发送群消息
     * @param groupId
     */
    public static void pushGroupMessage(String senderId,String groupId, ChatMsg chatMsg) {
        GroupService groupService = (GroupService) SpringUtil.getBean("groupServiceImp");
        UserService userService = (UserService) SpringUtil.getBean("userServiceImp");
        Set<TbGroupMember> groupMembers = groupService.getMembersByGroupId(groupId);
        Sid sid = new Sid();
        for(TbGroupMember groupMember : groupMembers){
            //去除发送者的id,发送者不再接收消息
            if(senderId.equals(groupMember.getUserid())){
                continue;
            }
            //1、接收者Id
            String receicerId = groupMember.getUserid();
            //2、接收者通道
            Channel channel = UserChannelRel.get(receicerId);
            //3、准备发送消息
            chatMsg.setSenderId(groupId);
            chatMsg.setReceiverId(receicerId);
            //4、保存发送消息
            chatMsg.setMsgId(sid.next());
            userService.saveMsg(chatMsg);
            //5、发送消息
            DataContent dataContent = new DataContent();
            dataContent.setAction(MsgActionEnum.CHAT.type);
            dataContent.setChatMsg(chatMsg);

            if(channel!=null){
                channel.writeAndFlush(new TextWebSocketFrame(JsonUtils.objectToJson(dataContent)));
            }

        }

    }
}
