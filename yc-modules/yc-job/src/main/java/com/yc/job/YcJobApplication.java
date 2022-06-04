package com.yc.job;

import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description:
 * @author: youcong
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
@EnableScheduling
public class YcJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcJobApplication.class, args);
        System.out.println("======定时任务微服务启动成功======");
    }
}
