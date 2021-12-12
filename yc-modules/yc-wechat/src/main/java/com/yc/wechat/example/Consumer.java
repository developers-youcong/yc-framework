package com.yc.wechat.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @description: 消费者
 * @author: youcong
 */
@Component
public class Consumer {
    // 使用JmsListener配置消费者监听的队列，其中text是接收到的消息
    @JmsListener(destination = "my.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer Receive:" + text);
    }
}
