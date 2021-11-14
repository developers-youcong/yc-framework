package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:28
 */
@Data
@TableName("yc_user")
public class UserEntity {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField("user_name")
    private String userName;

    private String password;

    private String email;

    private String phone;

    @TableField("nick_name")
    private String nickName;

    @TableField("company_id")
    private Integer companyId;

    private Integer sex;

    private Integer status;

    @TableField("create_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date createTime;

    @TableField("update_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", locale = "zh", timezone = "GMT+8")
    private Date updateTime;

}
