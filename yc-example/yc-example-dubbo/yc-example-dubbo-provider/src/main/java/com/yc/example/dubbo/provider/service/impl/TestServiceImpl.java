package com.yc.example.dubbo.provider.service.impl;

import com.yc.example.dubbo.provider.service.TestService;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @description:
 * @author: youcong
 */
@DubboService(version = "1.0")
public class TestServiceImpl implements TestService {
    @Override
    public String showName() {
        return "show server name";
    }
}
