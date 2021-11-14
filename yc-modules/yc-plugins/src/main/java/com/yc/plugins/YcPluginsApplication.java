package com.yc.plugins;

import com.yc.common.core.base.constant.ApplicationConst;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 22:21
 */
@SpringCloudApplication
@EnableFeignClients(basePackages = ApplicationConst.FEIGN_PACKAGE_SCANNER)
public class YcPluginsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcPluginsApplication.class, args);
        System.out.println("======插件微服务启动成功======");
    }
}
