package com.yc.example.poi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YcExamplePoiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExamplePoiApplication.class, args);
    }
}
