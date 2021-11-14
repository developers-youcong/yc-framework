package com.yc.job;

import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 22:20
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
public class YcJobApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcJobApplication.class, args);
        System.out.println("======定时任务微服务启动成功======");
    }
}
