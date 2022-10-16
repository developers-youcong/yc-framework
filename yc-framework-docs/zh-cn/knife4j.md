# 接口文档自动化

## 一、在对应的微服务模块中引入Maven依赖
```
        <dependency>
            <groupId>com.yc.framework</groupId>
            <artifactId>yc-common-knife4j</artifactId>
        </dependency>

```

## 二、代码配置
按照规则,在ApplicationConst.java定义微服务相关的应用名称、路由扫描包、Mapper扫描包。然后修改Knife4jConfiguration.java中的getBasePackage(String applicationName)、getTitle(String applicationName)、getDesc(String applicationName)等方法，依样画葫芦模仿写一个即可，非常简单。

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-knife4j


## 三、YC-Framework如何使用Knife4j
[从零开始学YC-Framework之Knife4j(https://youcongtech.com/2022/08/21/%E4%BB%8E%E9%9B%B6%E5%BC%80%E5%A7%8B%E5%AD%A6YC-Framework%E4%B9%8BKnife4j/)