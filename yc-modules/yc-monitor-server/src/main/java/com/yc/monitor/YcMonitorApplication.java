package com.yc.monitor;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description:
 * @author: youcong
 */
@EnableAdminServer
@SpringCloudApplication
public class YcMonitorApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcMonitorApplication.class, args);
        System.out.println("======监控微服务启动成功======");
    }
}
