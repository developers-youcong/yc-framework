# 链路追踪
关于链路追踪可阅读下面两篇文章(来源我的个人博客):

[我在M2公司做架构之链路追踪](https://youcongtech.com/2021/10/17/%E6%88%91%E5%9C%A8M2%E5%85%AC%E5%8F%B8%E5%81%9A%E6%9E%B6%E6%9E%84%E4%B9%8B%E9%93%BE%E8%B7%AF%E8%BF%BD%E8%B8%AA/)

[SpringCloud之分布式链路追踪](https://youcongtech.com/2020/11/06/SpringCloud%E4%B9%8B%E5%88%86%E5%B8%83%E5%BC%8F%E9%93%BE%E8%B7%AF%E8%BF%BD%E8%B8%AA/)

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-linktrack</artifactId>
</dependency>

```

## 二、配置
```
zipkin:
    base-url: http://127.0.0.1:9411
  sleuth:
    sampler:
      probability: 1

```