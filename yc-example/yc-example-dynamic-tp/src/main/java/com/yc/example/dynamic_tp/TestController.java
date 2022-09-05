package com.yc.example.dynamic_tp;

import com.dtp.core.DtpRegistry;
import com.dtp.core.thread.DtpExecutor;
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
        DtpExecutor dtpExecutor = DtpRegistry.getDtpExecutor("dtpExecutor1");
        dtpExecutor.execute(() -> System.out.println("test"));
        return "test";
    }
}
