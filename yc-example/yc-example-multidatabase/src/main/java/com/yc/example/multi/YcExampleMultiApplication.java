package com.yc.example.multi;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class YcExampleMultiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleMultiApplication.class, args);
    }
}
