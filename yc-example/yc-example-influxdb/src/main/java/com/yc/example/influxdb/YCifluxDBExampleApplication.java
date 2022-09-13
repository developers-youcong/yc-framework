package com.yc.example.influxdb;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class YCifluxDBExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(YCifluxDBExampleApplication.class, args);
    }


}
