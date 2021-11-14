package com.yc.common.core.base.dto.crawler;

import lombok.Data;

import java.util.Date;

/**
 * @description:
 * @author: youcong
 * @time: 2021/10/18 20:25
 */
@Data
public class PostCrawlerReqDTO {

    private String id;
    private String postAuthor;

    private String postTitle;

    private String postContent;

    private String description;

    private Long companyId;

    private String originUrl;

    private Date createTime;

    private Date updateTime;
}
