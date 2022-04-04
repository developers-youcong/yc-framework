package com.yc.example.netty;

import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication
public class YcExamleNettyApplication implements CommandLineRunner {
    @Value("${netty.port}")
    private Integer port;
    @Autowired
    private NettyServer nettyServer;

    public static void main(String[] args) {
        SpringApplication.run(YcExamleNettyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ChannelFuture channelFuture = nettyServer.lister(port);
        //增加虚拟机钩子函数
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            nettyServer.destroy();
        }));
        channelFuture.channel().closeFuture().channel();
    }

}
