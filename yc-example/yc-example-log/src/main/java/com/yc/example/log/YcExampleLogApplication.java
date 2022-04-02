package com.yc.example.log;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExampleLogApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleLogApplication.class, args);
    }
}
