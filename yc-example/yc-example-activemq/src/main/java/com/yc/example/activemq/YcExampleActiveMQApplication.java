package com.yc.example.activemq;


import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;


/**
 * @description:
 * @author: youcong
 */
@RestController
@SpringBootApplication
public class YcExampleActiveMQApplication {

    @Autowired
    private Producer producer;

    public static void main(String[] args) {
        SpringApplication.run(YcExampleActiveMQApplication.class, args);
    }


    @GetMapping("/test")
    public String test() {
        Destination destination = new ActiveMQQueue("yctest.queue");
        for (int i = 0; i < 100; i++) {
            producer.sendMessage(destination, "hello yc-framework activemq!");
        }
        return "消息发送成功";
    }
}
