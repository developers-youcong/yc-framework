package com.yc.example.clickhouse.entity;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class UserEntity {
    private int id;
    private String userName;
    private String passWord;
    private String phone;
    private String email;
    private String createDate;


}
