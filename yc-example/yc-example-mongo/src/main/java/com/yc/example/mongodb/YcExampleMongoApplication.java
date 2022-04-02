package com.yc.example.mongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExampleMongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleMongoApplication.class, args);
    }
}
