package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:40
 */
@Data
@TableName("yc_menu")
public class MenuEntity {

    @TableId
    private Long id;

    @TableField("menu_name")
    private String menuName;

    @TableField("menu_key")
    private String menuKey;

    @TableField("menu_url")
    private String menuUrl;

    @TableField("menu_type")
    private String menuType;

    @TableField("parent_id")
    private Long parentId;

    @TableField("menu_sort")
    private Long menuSort;

    private Integer status;
}
