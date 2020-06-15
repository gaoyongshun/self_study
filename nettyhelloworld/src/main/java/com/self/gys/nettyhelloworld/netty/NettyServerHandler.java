package com.self.gys.nettyhelloworld.netty;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

/**
 * 自定义Handler 需要继承netty规定好的某个HandlerAdapter
 * */
public class NettyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * ctx 上下文对象 含有管道 通道 地址等
     * msg 客户端信息
     *
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//        super.channelRead(ctx, msg);
        //netty 提供byteBuf
        ByteBuf buf =(ByteBuf) msg;
        System.out.println("客户端发送的信息:"+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客户端地址："+ctx.channel().remoteAddress());
    }

    /**
     * 数据读取完毕
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//        super.channelReadComplete(ctx);
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,客户端！",CharsetUtil.UTF_8));
    }
}
