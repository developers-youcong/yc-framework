package com.yc.file.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: youcong
 */
@Configuration
public class MinIOConfig {

    @Bean
    public MinioClient minioClient() {
        MinioClient minioClient = MinioClient.builder().endpoint("http://127.0.0.1:9000")
                .credentials("minioadmin", "minioadmin") //minIO默认用户名和密码，上生产一定要更改
                .build();

        return minioClient;
    }
}
