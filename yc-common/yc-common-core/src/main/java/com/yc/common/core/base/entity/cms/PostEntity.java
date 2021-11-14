package com.yc.common.core.base.entity.cms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:35
 */
@Data
@TableName("yc_post")
public class PostEntity{

    @TableId
    private String id;

    @TableField("post_author")
    private String postAuthor;

    @TableField("post_title")
    private String postTitle;

    @TableField("post_content")
    private String postContent;

    @TableField("post_excerpt")
    private String postExcerpt;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("comment_status")
    private Integer commentStatus;

    @TableField("company_id")
    private Long companyId;

    @TableField("post_status")
    private Integer postStatus;

    @TableField("post_password")
    private String postPassword;

    @TableField("category_id")
    private String categoryId;

    @TableField("tag_id")
    private String tagId;

    @TableField("origin_url")
    private String originUrl;

    @TableField("backgroup_img")
    private String backgroupImg;
}
