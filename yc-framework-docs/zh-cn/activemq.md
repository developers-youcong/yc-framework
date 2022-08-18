# 消息队列之ActiveMQ
ActiveMQ官网:
https://activemq.apache.org/

ActiveMQ文档:
https://activemq.apache.org/components/artemis/documentation/

ActiveMQ下载:
https://activemq.apache.org/components/classic/download/

ActiveMQ源代码:
https://github.com/apache/activemq

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-activemq</artifactId>
</dependency>

```



## 二、配置

```
spring:
  activemq:
    broker-url: tcp://${ACTIVEMQ_HOST:localhost}:${ACTIVEMQ:61616} # activemq连接地址
    user: ${ACTIVEMQ_USER:admin} # 用户名
    password: ${ACTIVEMQ_PASSWORD:admin} # 密码
    send-timeout: # 发送超时时间
    pool:
      enabled: false # 是否创建 JmsPoolConnectionFactory 连接池
      idle-timeout: 30s # 空闲连接超时时间
      max-connections: 50 # 连接池中最大连接数
      max-sessions-per-connection: 100 # 每个连接最大会话
```