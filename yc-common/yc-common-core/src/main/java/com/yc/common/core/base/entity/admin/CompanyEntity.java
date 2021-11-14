package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:37
 */
@Data
@TableName("yc_company")
public class CompanyEntity {

    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField("company_name")
    private String companyName;

    @TableField("company_code")
    private String companyCode;

    private String contact;

    private String phone;

    private String address;

    private String url;

    private String email;

    private Long count;

    private Integer status;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;
}
