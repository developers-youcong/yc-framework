package com.yc.example.clickhouse.controller;

import com.yc.example.clickhouse.entity.UserEntity;
import com.yc.example.clickhouse.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/selectById/{id}")
    public UserEntity selectById(@PathVariable("id") Integer id) {
        return userService.selectById(id);
    }

    @PostMapping("/saveData")
    public void saveData(@RequestBody UserEntity userInfo) {
        userService.saveData(userInfo);
    }

    @GetMapping("/selectList")
    public List<UserEntity> selectList() {
        return userService.selectList();
    }
}
