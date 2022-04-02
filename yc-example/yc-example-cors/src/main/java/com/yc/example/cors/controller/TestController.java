package com.yc.example.cors.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "yc-framework cors";
    }
}
