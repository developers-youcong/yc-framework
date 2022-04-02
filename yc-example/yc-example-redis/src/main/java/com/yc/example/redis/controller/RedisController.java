package com.yc.example.redis.controller;

import com.yc.common.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class RedisController {
    @Autowired
    private RedisService redisService;

    @GetMapping("/saveKey")
    public String saveKey(@RequestParam String key, @RequestParam String value) {
        redisService.setCacheObject(key, value);
        return "success";
    }

    @GetMapping("/getValue")
    public String getValue(@RequestParam String key) {
        return redisService.getCacheObject(key);
    }
}
