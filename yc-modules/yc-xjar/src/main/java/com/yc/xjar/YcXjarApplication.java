package com.yc.xjar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcXjarApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcXjarApplication.class, args);
        System.out.println("======Xjar 加密 微服务======");
    }
}
