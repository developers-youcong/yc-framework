package com.yc.example.clickhouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcClickhouseExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcClickhouseExampleApplication.class, args);
    }
}
