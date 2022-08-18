# 分布式定时任务之ElasticJob
ElasticJob官网:
https://shardingsphere.apache.org/elasticjob/index_zh.html

ElasticJob文档:
https://shardingsphere.apache.org/elasticjob/current/cn/overview/

ElasticJob下载:
https://shardingsphere.apache.org/elasticjob/current/cn/downloads/

ElasticJob源代码:
https://github.com/apache/shardingsphere-elasticjob

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-elasticjob</artifactId>
</dependency>

```

## 二、配置
```
elasticjob:
  regCenter:
    #zookeeper ip:port
    serverLists: 127.0.0.1:2181
    #命名空间，由自己定义即可
    namespace: my-job
  jobs:
    #定时任务名称，自定义名称
    myElasticJob:
      #定时任务的全路径名
      elasticJobClass: com.elastic.job.MyElasticJob
      #定时任务执行的cron表达式
      cron: 0/5 * * * * ?
      #分片数量
      shardingTotalCount: 10
```