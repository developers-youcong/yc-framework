package com.yc.example.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @description:
 * @author: youcong
 */
@Component
@Data
public class NettyServer {

    private Logger logger = LoggerFactory.getLogger(NettyServer.class);

    //NIO线程组
    private NioEventLoopGroup boos = new NioEventLoopGroup();
    private NioEventLoopGroup worker = new NioEventLoopGroup();
    private Channel channel;

    public ChannelFuture lister(int port) {
        ChannelFuture f = null;
        try {
            ServerBootstrap b = new ServerBootstrap()
                    .group(boos, worker)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            //采用分割符解决半包黏包
                            ch.pipeline().addLast(new LineBasedFrameDecoder(1024));
                            //字符串的编解码器
                            ch.pipeline().addLast(new StringDecoder());
                            ch.pipeline().addLast(new StringEncoder());
                            //添加自己的消息处理器
                            ch.pipeline().addLast(new ServerHandler());
                        }
                    });
            f = b.bind(port).sync();
            channel = f.channel();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (f != null && f.isSuccess()) {
                logger.info("Netty 服务端启动成功.....");
            } else {
                logger.info("Netty 服务端启动失败.....");
            }
        }
        return f;
    }

    //销毁方法
    public void destroy() {
        if (channel == null) {
            return;
        }
        channel.close();
        worker.shutdownGracefully();
        boos.shutdownGracefully();
    }
}
