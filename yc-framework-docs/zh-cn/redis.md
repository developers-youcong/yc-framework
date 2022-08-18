# Redis使用

## 一、引入Maven依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-redis</artifactId>
</dependency>
```

## 二、Redis配置
```
# Spring
spring:
  redis:
    host: 127.0.0.1
    port: 6379
    password: 
```

## 三、代码使用
```
@Autowired
private RedisService redisService;

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-redis