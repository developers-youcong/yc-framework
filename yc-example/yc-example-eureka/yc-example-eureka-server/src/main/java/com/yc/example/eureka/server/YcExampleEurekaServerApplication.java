package com.yc.example.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @description:
 * @author: youcong
 */
@EnableEurekaServer
@SpringBootApplication
public class YcExampleEurekaServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleEurekaServerApplication.class, args);
    }
}
