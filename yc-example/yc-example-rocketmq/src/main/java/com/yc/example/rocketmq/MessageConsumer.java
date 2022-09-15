package com.yc.example.rocketmq;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component
@RocketMQMessageListener(consumerGroup = "testBootGroup", topic = "TestTopic")
public class MessageConsumer implements RocketMQListener {
    @Override
    public void onMessage(Object message) {
        System.out.println("Received message : " + message);
    }
}