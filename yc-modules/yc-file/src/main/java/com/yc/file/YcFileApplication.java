package com.yc.file;

import com.yc.common.core.base.constant.ApplicationConst;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringCloudApplication
@MapperScan(ApplicationConst.MAPPER_FILE)
public class YcFileApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcFileApplication.class, args);
        System.out.println("======文件微服务启动成功======");
    }
}