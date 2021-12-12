package com.yc.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.jms.annotation.EnableJms;

/**
 * @description:
 * @author: youcong
 */
@SpringCloudApplication
@EnableJms
public class YcWechatApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcWechatApplication.class, args);
        System.out.println("======微信生态微服务启动成功======");
    }
}
