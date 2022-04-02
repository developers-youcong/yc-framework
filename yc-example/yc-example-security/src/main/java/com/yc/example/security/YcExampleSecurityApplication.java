package com.yc.example.security;

import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
public class YcExampleSecurityApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleSecurityApplication.class, args);
    }
}
