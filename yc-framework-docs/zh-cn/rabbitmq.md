# 消息队列之RabbitMQ
RabbitMQ官网:
https://www.rabbitmq.com/

RabbitMQ官方文档:
https://www.rabbitmq.com/documentation.html

RabbitMQ安装:
https://www.rabbitmq.com/download.html

RabbitMQ源代码:
https://github.com/rabbitmq/rabbitmq-server

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-rabbitmq</artifactId>
</dependency>
```

## 二、配置
```
spring:
  rabbitmq:
    host: 127.0.0.1
    port: 5672
    username: guest
    password: guest
```
