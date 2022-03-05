package com.yc.example.page.controller;

import com.yc.common.core.base.dto.admin.*;
import com.yc.common.core.base.result.RespBody;
import com.yc.example.page.service.ExampleUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 21:04
 */
@RestController
@Slf4j
@Api(tags = {"example"}, description = "example")
public class ExampleUserController {

    @Autowired
    private ExampleUserService userService;

    /**
     * 获取用户列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/queryUserPageListExample")
    @ApiOperation("获取用户列表")
    public RespBody queryUserPageListExample(@RequestBody UserPageReqDTO reqDTO) {
        log.info("/user/queryUserPageListExample:" + reqDTO);
        return RespBody.success(userService.queryUserPageListExample(reqDTO));
    }
}
