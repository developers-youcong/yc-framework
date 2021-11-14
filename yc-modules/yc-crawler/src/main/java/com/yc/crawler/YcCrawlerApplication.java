package com.yc.crawler;

import com.yc.common.core.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 22:14
 */
@SpringCloudApplication
@EnableScheduling
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
@MapperScan(ApplicationConst.MAPPER_CRAWLER)
public class YcCrawlerApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcCrawlerApplication.class, args);
        System.out.println("======Crawler微服务启动成功======");
    }
}
