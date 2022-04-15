package com.yc.example.dubbo.consumer;

import com.yc.example.dubbo.provider.service.TestService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {
    @DubboReference(version = "1.0")
    private TestService testService;

    @GetMapping("test1")
    public String test1() {
        return testService.showName();
    }
}
