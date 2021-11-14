package com.yc.cms;

import com.yc.common.core.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description:
 * @author: youcong
 * @time: 2021/8/24 22:11
 */
@SpringCloudApplication
@MapperScan(ApplicationConst.MAPPER_CMS)
public class YcCmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcCmsApplication.class, args);
        System.out.println("======CMS微服务启动成功======");
    }
}
