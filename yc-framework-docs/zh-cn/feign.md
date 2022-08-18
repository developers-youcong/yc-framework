# Feign

Feign是分布式微服务通信所要用到的。但针对分布式微服务一些场景并不需要Feign，故将Feign模块化，按需使用即可。

在对应的微服务模块引入如下依赖即可:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-openfeign</artifactId>
</dependency>

```