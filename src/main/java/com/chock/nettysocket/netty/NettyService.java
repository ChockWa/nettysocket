package com.chock.nettysocket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sun.reflect.generics.scope.Scope;

import java.net.InetSocketAddress;

/**
 * @auther: zhuohuahe
 * @date: 2019/3/14 16:22
 * @description:
 */
@Component
public class NettyService {

    public void run(){
        EventLoopGroup boosGrop = new NioEventLoopGroup();
        EventLoopGroup workerGrop = new NioEventLoopGroup();
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            //使用服务端初始化自定义类WebSocketChannelInitaializer
            serverBootstrap.group(boosGrop, workerGrop).channel(NioServerSocketChannel.class).childHandler(new WebSocketChannelInitaializer());

            //使用了不同的端口绑定方式
            ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
            //关闭连接
            channelFuture.channel().closeFuture().sync();
        } catch (Exception e){
            e.printStackTrace();
        }finally {
            //优雅关闭
            boosGrop.shutdownGracefully();
            workerGrop.shutdownGracefully();
        }
    }
}
