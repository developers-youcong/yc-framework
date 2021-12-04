# YC FrameWork

## 一、理念
致力于打造一款优秀的分布式微服务解决方案。

## 二、技术架构
![技术架构图](./doc/技术架构图-V1.0.jpg)

## 三、技术选型
- JDK版本：1.8；
- 项目依赖管理：Maven3.6.2；
- 版本控制工具：Git；
- 分布式框架:SpringCloud+SpringCloud Alibaba；
- 微服务基础框架：SpringBoot；
- 接口鉴权框架：Sa-Token；
- 缓存：Redis；
- 关系型数据库：MySQL；
- 接口文档自动生成框架：Knife4j；
- 持久层框架：MyBatis-Plus；
- 第三方工具类框架：Hutool；
- 数据库连接池：Druid；
- 多数据源框架：dynamic-datasource-spring-boot-starter；
- 限流熔断：Sentinel；
- 分库分表中间件：MyCat；
- 爬虫框架：JSOUP/WebMagic；
- 日志框架：Lombok；
- 服务注册与配置中心：Nacos；
- Excel处理:Apache Poi；
- 分布式定时任务：Quartz；
- 服务链路追踪：SpringCloud Sleuth+Zipkin；
- Word模板引擎：Poi-tl；
- 消息队列：Kafka；
- 大数据存储与计算处理：Hadoop；
- 分布式搜索引擎：Elastic Search；
- 文档数据库：MongoDB。

## 四、系统模块
````   
├── yc-gateway         // 网关服务 [8080]
├── yc-auth            // 认证服务 [8081]
├── yc-api             // 接口服务
├── yc-common          // 通用模块
│       └── yc-common-core                     // 核心模块
│       └── yc-common-knife4j                 // 接口文档自动生成模块
│       └── yc-common-redis                   // Redis模块
│       └── yc-common-security                // 安全模块
│       └── yc-common-elasticsearch           // ElasticSearch模块
│       └── yc-common-mongodb                 // MongoDB模块
│       └── yc-common-rabbitmq                // RabbitMQ模块
│                         
├── yc-modules         // 微服务模块
│       └── yc-admin                              // 统一用户微服务 [9000]
│       └── yc-cms                                 // 内容管理微服务 [9001]
│       └── yc-crawler                             // 爬虫微服务 [9002]
│       └── yc-file                                // 文件微服务 [9003]
│       └── yc-job                                // 定时任务服务 [9004]
│       └── yc-plugins                                // 插件微服务 [9005]
├──pom.xml                
````

## 五、功能
当前版本为1.0.1，所具有的功能如下:

- 用户登录/注册、退出；
- 统一微服务接口鉴权；
- 数据爬虫(爬取真气网、博客园、思否、CSDN等网站数据)；
- 分布式定时任务；
- 用户管理；
- 文章管理；
- 分类管理；
- 标签管理；
- 文件管理；
- 接口文档自动生成；
- Redis操作；
- Sentinel限流熔断；
- 分布式Token；
- 默认集成博客园、聚合等API；
- 集成ElasticSearch；
- 集成RabbitMQ;
- 集成MongoDB。



## 六、环境

### 1.开发环境
- IDE: IntelliJ IDEA 2018.2+版本以上均支持；
- DB: MySQL5.7.x或MySQL8.x版本均支持；
- JDK: JDK 1.8；
- Maven: Maven 3.0版本以上均支持；
- Redis: 5.x版本以上均支持；
- MongoDB:4.x版本以上均支持；
- ElasticSearch:7.x版本以上均支持；
- RabbitMQ:3.x版本以上均支持。

### 2.服务器部署环境
- DB:MySQL5.7.x或MySQL8.x版本均支持；
- JRE:JRE1.8；
- Redix:5.x版本以上均支持；
- MongoDB:4.x版本以上均支持；
- ElasticSearch:7.x版本以上均支持；
- RabbitMQ:3.x版本以上均支持；
- 操作系统:Windows Server和Ubuntu、CenOS等均支持。


## 七、项目启动
项目启动顺序分别为:
- yc-gateway；
- yc-auth；
- yc-admin；
- yc-cms；
- yc-crawler；
- yc-file；
- yc-job；
- yc-plugins。

其中涉及数据爬虫相关，必须确保yc-crawler、yc-plugins、yc-job等运行起来才行。

**注意**:
通过爬虫获取的数据只能用于个人学习研究，不能用于任何的商业用途，违反者，后果自负。

## 八、官方文档
文档地址:
http://framework.youcongtech.com/
