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



## 四、博客文章
[深入浅出NoSQL之Redis](https://mp.weixin.qq.com/s?__biz=MzUxODk0ODQ3Ng==&mid=2247487009&idx=1&sn=37713fcb8ebb792438ed80031f15782f&chksm=f9805d32cef7d424a569136403e396618ec5a1d2f5699fa1d71cae3fe7bba9d778f1c48c5959&token=730841189&lang=zh_CN#rd)