package com.yc.example.mongodb.vo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

/**
 * @description:
 * @author: youcong
 */
@Document(collection = "xx_collection")
@Data
public class ExampleEntity implements Serializable {
    @Field
    private String name;
    @Field
    private String email;
}
