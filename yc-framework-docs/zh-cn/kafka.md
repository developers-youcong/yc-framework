# 消息队列之Kafka
Kafka官网:
http://kafka.apache.org/

Kafka官方文档:
https://kafka.apache.org/documentation/

Kafka下载:
https://kafka.apache.org/downloads

Kafka源代码:
https://github.com/apache/kafka

## 一、引入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-kafka</artifactId>
</dependency>

```

## 二、配置
```
spring:
  #kafka配置
  kafka:
    #这里改为你的kafka服务器ip和端口号
    bootstrap-servers: 127.0.0.1:9092
    #=============== producer  =======================
    producer:
      #如果该值大于零时，表示启用重试失败的发送次数
      retries: 0
      #每当多个记录被发送到同一分区时，生产者将尝试将记录一起批量处理为更少的请求，默认值为16384(单位字节)
      batch-size: 16384
      #生产者可用于缓冲等待发送到服务器的记录的内存总字节数，默认值为3355443
      buffer-memory: 33554432
      #key的Serializer类，实现类实现了接口org.apache.kafka.common.serialization.Serializer
      key-serializer: org.apache.kafka.common.serialization.StringSerializer
      #value的Serializer类，实现类实现了接口org.apache.kafka.common.serialization.Serializer
      value-serializer: org.apache.kafka.common.serialization.StringSerializer
    #=============== consumer  =======================
    consumer:
      #用于标识此使用者所属的使用者组的唯一字符串
      group-id: test-consumer-group
      #当Kafka中没有初始偏移量或者服务器上不再存在当前偏移量时该怎么办，默认值为latest，表示自动将偏移重置为最新的偏移量
      #可选的值为latest, earliest, none
      auto-offset-reset: earliest
      #消费者的偏移量将在后台定期提交，默认值为true
      enable-auto-commit: true
      #如果'enable-auto-commit'为true，则消费者偏移自动提交给Kafka的频率（以毫秒为单位），默认值为5000。
      auto-commit-interval: 100
      #密钥的反序列化器类，实现类实现了接口org.apache.kafka.common.serialization.Deserializer
      key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
      #值的反序列化器类，实现类实现了接口org.apache.kafka.common.serialization.Deserializer
      value-deserializer: org.apache.kafka.common.serialization.StringDeserializer

```