# 分布式事务之Tx-LCN
GitHub源代码地址:
https://github.com/codingapi/tx-lcn

官方文档:
https://www.codingapi.com/

## 一、导入依赖
```

<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-txlcn</artifactId>
</dependency>

```

## 二、配置
```
tx-lcn:
  client:
    manager-address: 127.0.0.1:8070
  logger:
    enabled: true
    driver-class-name: com.mysql.cj.jdbc.Driver
    jdbc-url: jdbc:mysql://127.0.0.1:3306/tx-manager?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&serverTimezone=Asia/Shanghai&useSSL=false
    username: xxx
    password: xxx

```

## 三、启动类增加注解
```
@EnableDistributedTransaction

```

## 四、对应的方法加如下注解(controller和service均支持)
```
@LcnTransaction
@Transactional

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-txlcn