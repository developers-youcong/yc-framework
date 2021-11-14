package com.yc.common.core.base.entity.admin;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:44
 */
@Data
@TableName("yc_company_menu")
public class CompanyMenuEntity {

    @TableField("company_id")
    private Long companyId;

    @TableField("menu_id")
    private Long menuId;
}
