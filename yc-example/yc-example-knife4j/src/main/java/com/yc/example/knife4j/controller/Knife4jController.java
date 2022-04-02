package com.yc.example.knife4j.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Api(tags = {"Knife4jTest"}, description = "Knife4jTest")
public class Knife4jController {
    @GetMapping("/testKnife4j")
    @ApiOperation("It is a Test")
    public String testKnife4j() {
        return "It is a Test";
    }
}
