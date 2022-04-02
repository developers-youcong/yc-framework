package com.yc.example.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExampleEsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleEsApplication.class, args);
    }
}
