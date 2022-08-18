# ElasticSearch集成
如果你不了解ElasticSearch，可以通过以下链接进行相关了解:

ElasticSearch官网:
https://www.elastic.co/cn/elasticsearch/

下载:
https://www.elastic.co/cn/downloads/elasticsearch

源代码:
https://github.com/elastic/elasticsearch



## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-elasticsearch</artifactId>
</dependency>

```


## 二、配置
```
spring:
  elasticsearch:
    rest:
      uris: https://127.0.0.1:9200

```

## 三、使用

### 1.基于ElasticsearchTemplate
```
 @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

```



### 2.接口继承



#### (1)定义实体

```
@Data
@EqualsAndHashCode(callSuper = false)
//indexName 索引库名次，mysql中数据库的概念
//type 类型
//shards 默认分片数
//replicas 默认副本数量
@Document(indexName = "cms",type = "post",shards = 1,replicas = 0)

public class PostEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String ID;

    @Field(type = FieldType.Keyword)
    private String postTitle;

    @Field(type = FieldType.Keyword)
    private String postAuthor;

    ......
}
```



#### (2)Dao继承

```

public interface PostRepository extends ElasticsearchRepository<PostEntity, String> {
}

```



#### (3)Service及其ServiceImpl

关于Service及其ServiceImpl与平常Java通用型写法基本上一样，这里不再赘述。

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-es