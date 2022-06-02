package com.yc.cms.es.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 */
@Data
@Document(indexName = "post", createIndex = true)
public class PostEsVO {

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(type = FieldType.Text)
    private String postAuthor;

    @Field(type = FieldType.Text)
    private String postTitle;

    @Field(type = FieldType.Text)
    private String postContent;

    @Field(type = FieldType.Text)
    private String postExcerpt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_second")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_second")
    private Date updateTime;

    @Field(type = FieldType.Integer)
    private Integer commentStatus;

    @Field(type = FieldType.Long)
    private Long companyId;

    @Field(type = FieldType.Integer)
    private Integer postStatus;

    @Field(type = FieldType.Text)
    private String postPassword;

    @Field(type = FieldType.Text)
    private String categoryId;

    @Field(type = FieldType.Text)
    private String tagId;

    @Field(type = FieldType.Text)
    private String originUrl;

    @Field(type = FieldType.Text)
    private String backgroupImg;
}
