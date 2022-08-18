# 分布式定时任务之Xxl-Job
关于如何整合，参考这篇文章:
[SpringBoot整合Xxl-Job](https://youcongtech.com/2020/05/22/SpringBoot%E6%95%B4%E5%90%88Xxl-Job/)

Xxl-Job中文文档:
https://www.xuxueli.com/xxl-job/

Xxl-Job源代码:
https://github.com/xuxueli/xxl-job

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-xxljob</artifactId>
</dependency>

```

## 二、配置
```
#xxl-job
xxl:
  job:
    admin:
      addresses:http://127.0.0.1:8080/xxl-job-admin
    executor:
      appname: Application1-Job
      ip:
      port: 9920
      logpath: /data/xxl-job/jobhandle_log
      logretentiondays: -1
    accessToken:
```