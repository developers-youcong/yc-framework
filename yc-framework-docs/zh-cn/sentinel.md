# Sentinel

关于Sentinel相关可阅读下面的文章:

[SpringCloud之Sentinel](https://youcongtech.com/2020/11/07/SpringCloud%E4%B9%8BSentinel/)

[我在M2公司做架构之限流](https://youcongtech.com/2021/10/30/%E6%88%91%E5%9C%A8M2%E5%85%AC%E5%8F%B8%E5%81%9A%E6%9E%B6%E6%9E%84%E4%B9%8B%E9%99%90%E6%B5%81/)

cd ${开发者本地文件路径}/yc-framework/doc/run目录下,执行如下命令，即可运行Sentinel:
```
java -jar sentinel-dashboard.jar

```

默认用户名和密码如下:
sentinel/sentinel_gateway

针对微服务应用中需要Sentinel的，引入对应依赖即可:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-sentinel</artifactId>
</dependency>
```