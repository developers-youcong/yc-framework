package com.yc.example.postgresql.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
@TableName("test")
public class TestEntity {

    private Integer id;
    private String name;
}
