# 微服务监控

## 一、服务端
服务端为yc-monitor-server项目，位于yc-modules下。启动很简单，与启动SpringBoot应用一样。


## 二、客户端
对应的客户端需要引入如下依赖:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-monitor</artifactId>
</dependency>

```

## 三、效果图
![图一](monitor/1.png)

## 四、YC-Framework如何使用监控
[从零开始学YC-Framework之微服务监控](https://youcongtech.com/2022/06/19/%E4%BB%8E0%E5%BC%80%E5%A7%8B%E5%AD%A6YC-Framework%E4%B9%8B%E5%BE%AE%E6%9C%8D%E5%8A%A1%E7%9B%91%E6%8E%A7/)