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