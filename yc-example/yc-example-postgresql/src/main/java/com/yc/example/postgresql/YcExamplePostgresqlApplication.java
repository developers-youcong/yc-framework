package com.yc.example.postgresql;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication
@MapperScan("com.yc.example.postgresql.dao")
public class YcExamplePostgresqlApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExamplePostgresqlApplication.class, args);
    }
}
