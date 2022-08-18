# 分布式日志ELK

官方网站:
https://www.elastic.co/cn/

Elastic-Search Download:
https://www.elastic.co/cn/downloads/past-releases/elasticsearch-7-4-0

Kibana Download:
https://www.elastic.co/cn/downloads/past-releases/kibana-7-4-0

LogStash Download:
https://www.elastic.co/cn/downloads/past-releases/logstash-7-4-0

微服务中要使用，只需引入如下依赖即可:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-logstash</artifactId>
</dependency>

```

参考logback_template.xml(模板配置位于yc-common-logstash中的resources目录下)配置对应的微服务即可。