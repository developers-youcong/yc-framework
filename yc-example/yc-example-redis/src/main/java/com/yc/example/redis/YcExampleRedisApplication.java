package com.yc.example.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExampleRedisApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleRedisApplication.class, args);
    }
}
