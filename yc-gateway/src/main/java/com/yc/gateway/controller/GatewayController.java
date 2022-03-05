package com.yc.gateway.controller;

import com.yc.common.core.base.result.RespBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2022/1/9 17:02
 */
@RestController
public class GatewayController {
    @PostMapping("/")
    public RespBody index() {
        return RespBody.success();
    }
}
