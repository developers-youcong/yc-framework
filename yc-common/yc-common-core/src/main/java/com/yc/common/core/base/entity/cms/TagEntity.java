package com.yc.common.core.base.entity.cms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:49
 */
@Data
@TableName("yc_tag")
public class TagEntity {

    @TableId
    private Long id;

    @TableField("tag_name")
    private String tagName;

    private Integer status;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("company_id")
    private Long companyId;

    @TableField(exist = false)
    private String companyName;
}
