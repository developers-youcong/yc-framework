# MongoDB集成
MongoDB官网:
https://www.mongodb.com/

MongoDB官方文档:
https://docs.mongodb.com/

MongoDB中文网:
https://www.mongodb.org.cn/

MongoDB源代码:
https://github.com/mongodb/mongo

MongoDB下载:
https://www.mongodb.com/try/download/community


## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-mongodb</artifactId>
</dependency>

```
## 二、配置
```
spring:
  data:
    mongodb:
      host: 127.0.0.1
      port: 27017
      database: yc-framework
```


## 三、使用

### 1.定义文档对象
```
@Document(collection = "xx_collection")
@Data
public class XxEntity implements Serializable {
    @Field
    private String name;
    @Field
    private String email;
}

```

### 2.核心封装类调用
```
@Autowired
private MongoService mongoService;

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-mongo