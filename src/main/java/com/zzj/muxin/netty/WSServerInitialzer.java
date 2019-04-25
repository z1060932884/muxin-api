package com.zzj.muxin.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;

public class WSServerInitialzer extends ChannelInitializer<SocketChannel> {

    protected void initChannel(SocketChannel socketChannel) throws Exception {

        ChannelPipeline channelPipeline = socketChannel.pipeline();

        /**
         * websocket 基于http协议
         */
        channelPipeline.addLast(new HttpServerCodec());
        /**
         * 对写大数据流的支持
         */
        channelPipeline.addLast(new ChunkedWriteHandler());
        /**
         * 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
         * 几乎在netty中的都会使用此handler了
         */
        channelPipeline.addLast(new HttpObjectAggregator(1024*64));

        //================================以上使用于支持http协议============================================


        // ====================== 增加心跳支持 start    ======================
        // 针对客户端，如果在1分钟时没有向服务端发送读写心跳(ALL)，则主动断开
        // 如果是读空闲或者写空闲，不处理
        channelPipeline.addLast(new IdleStateHandler(8, 10, 12));
        // 自定义的空闲状态检测
        channelPipeline.addLast(new HeartBeatHandler());
        // ====================== 增加心跳支持 end    ======================



        // ====================== 以下是支持httpWebsocket ======================
        /**
         * webSocket服务器处理的协议，用于指定给客户端连接访问的路由：/ws
         * 本handler会帮你处理一些繁重的复杂的事
         * 会帮你处理握手动作：handshaking（close，ping，pong）ping+pong=心跳
         * 对于webSocket来讲，都是以frames进行传输，不同的数据类型对应的frames也不同
         */
        channelPipeline.addLast(new WebSocketServerProtocolHandler("/ws"));

        channelPipeline.addLast(new ChatHandler());
    }
}
