# 数据初始化

## 一、数据初始化
### 1.进入sql文件存放目录
```
cd yc-framework/doc/sql

```

### 2.将sql文件迁移至数据库中执行
```
source yc-framework.sql;
source nacos.sql;
source tx-lcn.sql;
source xxl_job.sql;
source init.sql;
```

## 二、Nacos分布式配置文件初始化
需手动新建，由开源爱好者或其它需要的朋友自行按需新建对应的即可。

### 1.yc-gateway-dev.yml
```
spring:
  cloud:
    gateway:
      discovery:
        locator:
          lowerCaseServiceId: true
          enabled: true
      routes:
        ## auth
        - id: yc-auth
          uri: lb://yc-auth
          predicates:
            - Path=/cert/**
          filters:
            - SwaggerHeaderFilter
            - StripPrefix=1
        ## admin
        - id: yc-admin
          uri: lb://yc-admin
          predicates:
            - Path=/admin/**
          filters:
            - SwaggerHeaderFilter
            - StripPrefix=1
        ## cms
        - id: yc-cms
          uri: lb://yc-cms
          predicates:
            - Path=/cms/**
          filters:
            - SwaggerHeaderFilter
            - StripPrefix=1
        ## file
        - id: yc-file
          uri: lb://yc-file
          predicates:
            - Path=/file/**
          filters:
            - SwaggerHeaderFilter
            - StripPrefix=1
# 打开客户端的监控
management:
  endpoints:
    sensitive: false
    web:
      exposure:
        include: '*'


```

### 2.yc-auth-dev.yml
```
spring:
  zipkin:
    base-url: http://127.0.0.1:9411
  sleuth:
    sampler:
      probability: 1
# 配置数据源
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yc-framework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: xxxx
    password: xxxx
# mybatis-plus相关配置
mybatis-plus:
  # xml扫描，多个目录用逗号或者分号分隔（告诉 Mapper 所对应的 XML 文件位置）
  mapper-locations: classpath:mapper/*.xml
  configuration:
    # 是否开启自动驼峰命名规则映射:从数据库列名到Java属性驼峰命名的类似映射
    map-underscore-to-camel-case: true
    # 如果查询结果中包含空值的列，则 MyBatis 在映射的时候，不会映射这个字段
    call-setters-on-nulls: true
    # 这个配置会将执行的sql打印出来，在开发或测试的时候可以用
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl
# Sa-Token配置
sa-token: 
    # token名称 (同时也是cookie名称)
    token-name: satoken
    # token有效期，单位s 默认30天, -1代表永不过期 
    timeout: 2592000
    # token临时有效期 (指定时间内无操作就视为token过期) 单位: 秒
    activity-timeout: -1
    # 是否允许同一账号并发登录 (为true时允许一起登录, 为false时新登录挤掉旧登录) 
    is-concurrent: true
    # 在多人登录同一账号时，是否共用一个token (为true时所有登录共用一个token, 为false时每次登录新建一个token) 
    is-share: false
    # token风格
    token-style: uuid
    # 是否输出操作日志 
    is-log: false

```

### 3.application-dev.yml
```
spring: 
   redis:
    host: 127.0.0.1
    port: 6379
    password: 
    lettuce:
      pool:
        max-active: 1500
        max-wait: 5000
        max-idle: 500
        min-idle: 100
        shutdown-timeout: 1000
files:
  access_url: http://computer.youcongtech.com
#请求处理的超时时间
ribbon:
  ReadTimeout: 10000
  ConnectTimeout: 10000

# feign 配置
feign:
  sentinel:
    enabled: true
  okhttp:
    enabled: true
  httpclient:
    enabled: false
  client:
    config:
      default:
        connectTimeout: 100000
        readTimeout: 100000
  compression:
    request:
      enabled: false
    response:
      enabled: false
# 打开客户端的监控
management:
  endpoints:
    sensitive: false
    web:
      exposure:
        include: '*'

```

### 4.yc-admin-dev.yml
```
spring:
# 配置数据源
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yc-framework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: xxxx
    password: xxxx
# mybatis-plus相关配置
mybatis-plus:
  # xml扫描，多个目录用逗号或者分号分隔（告诉 Mapper 所对应的 XML 文件位置）
  mapper-locations: classpath:mapper/*.xml

```

### 5.yc-cms-dev.yml
```
spring:
# 配置数据源
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yc-framework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: xxxx
    password: xxxx
# mybatis-plus相关配置
mybatis-plus:
  # xml扫描，多个目录用逗号或者分号分隔（告诉 Mapper 所对应的 XML 文件位置）
  mapper-locations: classpath:mapper/*.xml

```

### 6.yc-crawler-dev.yml
```
spring:
# 配置数据源
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yc-framework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: xxxx
    password: xxxx
# mybatis-plus相关配置
mybatis-plus:
  # xml扫描，多个目录用逗号或者分号分隔（告诉 Mapper 所对应的 XML 文件位置）
  mapper-locations: classpath:mapper/*.xml

```

### 7.yc-file-dev.yml
```
spring:
# 配置数据源
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/yc-framework?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai
    username: xxxx
    password: xxxx
# mybatis-plus相关配置
mybatis-plus:
  # xml扫描，多个目录用逗号或者分号分隔（告诉 Mapper 所对应的 XML 文件位置）
  mapper-locations: classpath:mapper/*.xml
  configuration:
    # 是否开启自动驼峰命名规则映射:从数据库列名到Java属性驼峰命名的类似映射
    map-underscore-to-camel-case: true
    # 如果查询结果中包含空值的列，则 MyBatis 在映射的时候，不会映射这个字段
    call-setters-on-nulls: true
    # 这个配置会将执行的sql打印出来，在开发或测试的时候可以用
    log-impl: org.apache.ibatis.logging.stdout.StdOutImpl

```

### 8.yc-job-dev.yml
```
spring:
  # Quartz 的配置，对应 QuartzProperties 配置类
  quartz:
    job-store-type: memory # Job 存储器类型。默认为 memory 表示内存，可选 jdbc 使用数据库。
    auto-startup: true # Quartz 是否自动启动
    startup-delay: 0 # 延迟 N 秒启动
    wait-for-jobs-to-complete-on-shutdown: true # 应用关闭时，是否等待定时任务执行完成。默认为 false ，建议设置为 true
    overwrite-existing-jobs: false # 是否覆盖已有 Job 的配置
    properties: # 添加 Quartz Scheduler 附加属性
      org:
        quartz:
          threadPool:
            threadCount: 25 # 线程池大小。默认为 10 。
            threadPriority: 5 # 线程优先级
            class: org.quartz.simpl.SimpleThreadPool # 线程池类型
#    jdbc: # 这里暂时不说明，使用 JDBC 的 JobStore 的时候，才需要配置

```

### 9.api.properties
```
cnblogs_clientId=xxxx
cnblogs_clientSecret=xxxx
phone_appkey=xxxx
ip_appkey=xxxx
news_top_appkey=xxxx
weather_appkey=xxxx
er_appkey=xxxx
hit_appkey=xxxx
cons_appkey=xxxx
cale_appkey=xxxx
qq_appkey=xxxx
book_appkey=xxxx
dream_appkey=xxxx
joke_appkey=xxxx

```

### 10.yc-wechat-dev.yml
```
wx_public:
 app_id: xxxx
 app_secret: xxxx
 token: xxxx
 aes_key: xxxx

```