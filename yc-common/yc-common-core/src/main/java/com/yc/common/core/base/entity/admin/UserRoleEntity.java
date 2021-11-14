package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:34
 */
@Data
@TableName("yc_user_role")
public class UserRoleEntity {

    @TableField("user_id")
    private String userId;

    @TableField("role_id")
    private String roleId;
}
