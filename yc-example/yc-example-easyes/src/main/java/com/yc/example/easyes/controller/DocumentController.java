package com.yc.example.easyes.controller;

import cn.easyes.common.utils.Assert;
import cn.easyes.core.conditions.LambdaEsQueryWrapper;
import com.yc.example.easyes.entity.DocumentEntity;
import com.yc.example.easyes.mapper.DocumentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class DocumentController {

    @Autowired
    private DocumentMapper documentMapper;

    @GetMapping("/add")
    public void test() {
        // 测试插入数据
        DocumentEntity document = new DocumentEntity();
        document.setTitle("Hello");
        document.setContent("Hello Easy ES");
        int successCount = documentMapper.insert(document);
        System.out.println(successCount);
    }

    @GetMapping("/query")
    public DocumentEntity query() {
        // 测试查询
        String title = "Hello";
        LambdaEsQueryWrapper<DocumentEntity> wrapper = new LambdaEsQueryWrapper<>();
        wrapper.eq(DocumentEntity::getTitle, title);
        DocumentEntity document = documentMapper.selectOne(wrapper);
        System.out.println(document);
        return document;
    }
}
