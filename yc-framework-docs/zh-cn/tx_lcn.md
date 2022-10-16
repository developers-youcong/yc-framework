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

## 五、博客文章
[深入浅出分布式事务之Tx-LCN](https://youcongtech.com/2022/04/16/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BA%E5%88%86%E5%B8%83%E5%BC%8F%E4%BA%8B%E5%8A%A1%E4%B9%8BTx-LCN/)