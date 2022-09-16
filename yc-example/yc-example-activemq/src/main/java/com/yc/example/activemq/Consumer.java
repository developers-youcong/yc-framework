package com.yc.example.activemq;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
/**
 * @description:
 * @author: youcong
 */
@Component
public class Consumer {
    @JmsListener(destination = "yctest.queue")
    public void receiveQueue(String text) {
        System.out.println("Consumer收到的报文为:"+text);
    }
}
