package com.yc.example.txlcn;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @description:
 * @author: youcong
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableDistributedTransaction
public class YcExampleTxLCNApplication {
    public static void main(String[] args) {
        SpringApplication.run(YcExampleTxLCNApplication.class, args);
    }


}
