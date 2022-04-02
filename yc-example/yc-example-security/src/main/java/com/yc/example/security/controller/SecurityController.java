package com.yc.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class SecurityController {

    @GetMapping("/test001")
    public String test001() {
        return "test001";
    }


    @GetMapping("/test002")
    public String test002() {
        return "test002";
    }
}
