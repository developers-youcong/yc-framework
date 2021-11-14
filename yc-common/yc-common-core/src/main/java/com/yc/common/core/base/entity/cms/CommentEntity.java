package com.yc.common.core.base.entity.cms;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:53
 */
@Data
@TableName("yc_comment")
public class CommentEntity {
    @TableId
    private String id;

    @TableField("comment_post_id")
    private String commentPostId;

    @TableField("comment_author")
    private String comment_author;

    @TableField("comment_email")
    private String commentEmail;

    @TableField("comment_url")
    private String commentUrl;

    @TableField("comment_ip")
    private String commentIp;

    @TableField("comment_status")
    private Integer commentStatus;

    @TableField("comment_content")
    private String commentContent;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

    @TableField("company_id")
    private Long companyId;


}
