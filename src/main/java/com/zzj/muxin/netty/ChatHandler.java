package com.zzj.muxin.netty;

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
    private ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame)
            throws Exception {

        //获取客户端出来的消息
        String message= textWebSocketFrame.text();
        System.out.println("接收到的数据--->"+message);

        for(Channel channel : channels){
            channel.writeAndFlush(new TextWebSocketFrame("服务器接收到消息--->"
                    + LocalDateTime.now()+"----消息为-->"+message));
        }
        /**
         * 下面的方法和for循环一致
         */
        channels.writeAndFlush(new TextWebSocketFrame("服务器接收到消息--->"
                + LocalDateTime.now()+"----消息为-->"+message));

    }


    /**
     * 当客户端连接服务端后，获取客户端的channel，并且放到channelGroup中去进行管理
     * @param ctx
     * @throws Exception
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);
        //当触发handlerRemoved，channelGroup会自动移除对应客户端的channel
//        channels.remove(ctx.channel());
        System.out.println("当前客户端断开的长channelId-->"+ctx.channel().id().asLongText());
        System.out.println("当前客户端断开的短channelId-->"+ctx.channel().id().asLongText());
    }
}
