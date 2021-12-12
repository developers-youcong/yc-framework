package com.yc.wechat.controller;

import com.yc.common.core.base.result.ResultBody;
import com.yc.wechat.example.Producer;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Slf4j
@Api(tags = {"ActiveMQ测试"}, description = "ActiveMQ测试")
@RequestMapping("/example")
public class ExampleController {
    @Autowired
    private Producer producer;

    @PostMapping("/test")
    public ResultBody test() {
        Destination destination = new ActiveMQQueue("my.queue");
        producer.sendMessage(destination, "hello world");
        return ResultBody.success();
    }
}
