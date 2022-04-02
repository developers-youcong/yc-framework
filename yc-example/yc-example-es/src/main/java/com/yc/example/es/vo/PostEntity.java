package com.yc.example.es.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

/**
 * @description:
 * @author: youcong
 */
@Data
@EqualsAndHashCode(callSuper = false)
//indexName 索引库名次，mysql中数据库的概念
//type 类型
//shards 默认分片数
//replicas 默认副本数量
@Document(indexName = "cms", type = "post", shards = 1, replicas = 0)
public class PostEntity implements Serializable {

    private static final long serialVersionUID = -1L;

    @Id
    private String ID;

    @Field(type = FieldType.Keyword)
    private String postTitle;

    @Field(type = FieldType.Keyword)
    private String postAuthor;

}