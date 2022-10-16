# Feign

Feign是分布式微服务通信所要用到的。但针对分布式微服务一些场景并不需要Feign，故将Feign模块化，按需使用即可。

在对应的微服务模块引入如下依赖即可:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-openfeign</artifactId>
</dependency>

```

# YC-Framework如何使用Feign
[从零开始学YC-Framework之微服务通信](https://youcongtech.com/2022/09/18/%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E5%AD%A6YC-Framework%E4%B9%8B%E5%BE%AE%E6%9C%8D%E5%8A%A1%E9%80%9A%E4%BF%A1/)
