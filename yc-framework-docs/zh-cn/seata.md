# 分布式事务之Seata
Seata官网:
https://seata.io/zh-cn/

Seata文档:
https://seata.io/zh-cn/docs/overview/what-is-seata.html

Seata下载:
https://seata.io/zh-cn/blog/download.html

Seata源代码:
https://github.com/seata/seata

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-seata</artifactId>
</dependency>

```

## 二、配置
```
seata:
  enabled: true
  application-id: ${spring.application.name}
  txServiceGroup: my_test_tx_group
  # 是否开启数据源自动代理 如果不开启设置为false
  enable-auto-data-source-proxy: true
  registry:
    type: nacos
    nacos:
      application: seata-server
      server-addr: localhost:8848
      namespace:
  config:
    type: nacos
    nacos:
      namespace:
      serverAddr: localhost:8848
      group: SEATA_GROUP
```

## 三、代码使用
具体接口实现方法加注解即可:
```
@GlobalTransactional(rollbackFor = Exception.class)

```

## 四、博客文章
[深入浅出分布式事务之Seata](https://youcongtech.com/2022/04/16/%E6%B7%B1%E5%85%A5%E6%B5%85%E5%87%BA%E5%88%86%E5%B8%83%E5%BC%8F%E4%BA%8B%E5%8A%A1%E4%B9%8BSeata/)