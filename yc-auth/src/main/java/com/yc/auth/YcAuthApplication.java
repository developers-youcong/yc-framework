package com.yc.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 21:49
 */
@SpringCloudApplication
@MapperScan("com.yc.auth.mapper")
public class YcAuthApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcAuthApplication.class, args);
        System.out.println("======认证启动成功======");
    }
}
