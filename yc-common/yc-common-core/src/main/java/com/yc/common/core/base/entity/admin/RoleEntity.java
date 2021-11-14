package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:35
 */
@Data
@TableName("yc_role")
public class RoleEntity {

    @TableField
    private String id;

    @TableField("role_name")
    private String roleName;

    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;
}
