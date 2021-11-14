package com.yc.admin;

import com.yc.common.core.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 22:00
 */
@SpringCloudApplication
@MapperScan(ApplicationConst.MAPPER_ADMIN)
public class YcAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcAdminApplication.class, args);
        System.out.println("======后台管理微服务启动成功======");
    }
}
