package com.yc.example.log;

import com.yc.common.log.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {

    @GetMapping("/test")
    @Log(value = "这是一个测试", isSaveReqData = true)
    public String test(@RequestParam String name) {
        return name;
    }
}
