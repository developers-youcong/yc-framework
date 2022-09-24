package com.yc.example.postgresql.controller;

import com.yc.example.postgresql.dao.TestMapper;
import com.yc.example.postgresql.entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {

    @Autowired
    private TestMapper testMapper;


    @PostMapping("/add")
    public Integer add(@RequestBody TestEntity testEntity) {
        return testMapper.insert(testEntity);
    }

    @GetMapping("/list")
    public List<TestEntity> list() {
        return testMapper.selectList(null);
    }

    @PutMapping("/update")
    public Integer update(@RequestBody TestEntity testEntity) {
        return testMapper.updateById(testEntity);
    }

    @DeleteMapping("/del")
    public Integer del(@RequestParam Integer id) {
        return testMapper.deleteById(id);
    }
}
