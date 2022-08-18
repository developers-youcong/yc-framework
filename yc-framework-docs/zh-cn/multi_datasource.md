# 多数据源
官方文档:
https://mp.baomidou.com/guide/dynamic-datasource.html

源代码:
https://github.com/baomidou/dynamic-datasource-spring-boot-starter

## 一、导入依赖
```
<dependency>
    <groupId>com.baomidou</groupId>
    <artifactId>dynamic-datasource-spring-boot-starter</artifactId>
    <version>2.5.4</version>
</dependency>

```

## 二、核心配置文件内容
```
spring:
  datasource:
    dynamic:
      primary: db1 #设置默认的数据源,默认值为master
      datasource:
        db1:  #数据源db1
          driver-class-name: com.mysql.jdbc.Driver
          url: jdbc:mysql://127.0.0.1:3306/wordpress_master?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
          username: root
          password: 123456
        db2: #数据源db2
          driver-class-name: com.mysql.jdbc.Driver
          url: jdbc:mysql://127.0.0.1:3306/wordpress_slave?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
          username: root
          password: 123456
      type: com.alibaba.druid.pool.DruidDataSource
      druid:
        initial-size: 10
        max-active: 100
        min-idle: 10
        max-wait: 60000
        pool-prepared-statements: true
        max-pool-prepared-statement-per-connection-size: 20
        time-between-eviction-runs-millis: 60000
        min-evictable-idle-time-millis: 300000
        #Oracle需要打开注释
        #validation-query: SELECT 1 FROM DUAL
        test-while-idle: true
        test-on-borrow: false
        test-on-return: false
        stat-view-servlet:
          enabled: true
          url-pattern: /druid/*
          #login-username: admin
          #login-password: admin
        filter:
          stat:
            log-slow-sql: true
            slow-sql-millis: 1000
            merge-sql: false
          wall:
            config:
              multi-statement-allow: true

```
## 三、代码中使用
Dao或ServiceImpl代码中添加如下注解即可:
```
@DS("db2")

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-multidatabase