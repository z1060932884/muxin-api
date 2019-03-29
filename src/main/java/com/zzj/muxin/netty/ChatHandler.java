package com.zzj.muxin.netty;

import com.zzj.muxin.enums.MsgActionEnum;
import com.zzj.muxin.utils.JsonUtils;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.time.LocalDateTime;

public class ChatHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    /**
     * 记录管理所有客户端的channel
     */
    private ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame)
            throws Exception {

        //获取客户端出来的消息
        String message= textWebSocketFrame.text();

        //1.获取客户端发来的消息
        DataContent dataContent = JsonUtils.jsonToPojo(message,DataContent.class);
        //2.判断消息类型，根据不同的类型处理不同的业务
        Integer action = dataContent.getAction();
        if(action == MsgActionEnum.CONNECT.type){
            //  2.1 当websocket 第一次open的时候，初始化channel,把channel和userId关联起来

        }else if(action == MsgActionEnum.CHAT.type){
            //  2.2 聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态（未签收）

        }else if(action == MsgActionEnum.SIGNED.type){
            //  2.3 签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态（已签收）

        }else if(action == MsgActionEnum.PULL_FRIEND.type){

        }else if(action == MsgActionEnum.KEEPALIVE.type){
            //  2.4 心跳类型的消息

        }





    }


    /**
     * 当客户端连接服务端后，获取客户端的channel，并且放到channelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        users.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        //当触发handlerRemoved，channelGroup会自动移除对应客户端的channel
        users.remove(ctx.channel());
     
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        users.remove(ctx.channel());
    }
}
