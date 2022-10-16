# 消息队列之RocketMQ
RocketMQ官网:
http://rocketmq.apache.org/

RocketMQ文档:
http://rocketmq.apache.org/docs/quick-start/

RocketMQ下载:
http://rocketmq.apache.org/dowloading/releases/

RocketMQ源代码:
https://github.com/apache/rocketmq

## 一、引入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-rocketmq</artifactId>
</dependency>


```

## 二、配置文件配置
```
rocketmq:
  producer:
    # 支持配置多个连接
    producerlist:
      - groupName: ${spring.application.name}
        # 生产者唯一标识
        producerId: chenkeTest
        # mq的nameserver地址
        namesrvAddr: 127.0.0.1:9876
        # 消息最大长度 默认 1024 * 4 (4M)
        maxMessageSize: 4096
        # 发送消息超时时间，默认 3000
        sendMsgTimeOut: 3000
        # 发送消息失败重试次数，默认2
        retryTimesWhenSendFailed: 2

```

## 三、YC-Framework如何使用RocketMQ
[从零开始学YC-Framework之RocketMQ](https://youcongtech.com/2022/10/06/%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E5%AD%A6YC-Framework%E4%B9%8BRocketMQ/)