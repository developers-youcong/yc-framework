package com.yc.plugins;

import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: youcong
 */
@EnableDiscoveryClient
@EnableCircuitBreaker
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
public class YcPluginsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcPluginsApplication.class, args);
        System.out.println("======插件微服务启动成功======");
    }
}
