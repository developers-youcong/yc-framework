package com.yc.example.easyes.entity;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class DocumentEntity {
    /**
     * es中的唯一id
     */
    private String id;
    /**
     * 文档标题
     */
    private String title;
    /**
     * 文档内容
     */
    private String content;
}
