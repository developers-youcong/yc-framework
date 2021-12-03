package com.yc.common.mongodb.vo;

/**
 * @description:
 * @author: youcong
 * @time: 2021/12/3 15:20
 */

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Document(collection = "contact_me")
@Data
public class ContactMeEntity implements Serializable {
    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String content;
}