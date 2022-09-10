package com.yc.example.easyes;

import cn.easyes.starter.register.EsMapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication
@EsMapperScan("com.yc.example.easyes.mapper")
public class YcExampleEasyEsApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleEasyEsApplication.class, args);
    }
}
