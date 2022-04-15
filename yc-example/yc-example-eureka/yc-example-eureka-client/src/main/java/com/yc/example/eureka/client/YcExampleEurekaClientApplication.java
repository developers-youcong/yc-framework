package com.yc.example.eureka.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class YcExampleEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleEurekaClientApplication.class, args);
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
