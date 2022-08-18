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