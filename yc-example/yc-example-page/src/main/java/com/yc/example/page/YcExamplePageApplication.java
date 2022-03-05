package com.yc.example.page;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication
@MapperScan("com.yc.example.page.mapper")
public class YcExamplePageApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExamplePageApplication.class, args);
    }
}
