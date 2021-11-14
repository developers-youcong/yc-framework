package com.yc.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/23 21:58
 */
@EnableDiscoveryClient
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcGateWayApplication.class, args);
        System.out.println("=====网关微服务启动成功=====");
    }
}
