package com.yc.example.cxf.service.impl;

import com.yc.example.cxf.service.UserService;
import org.springframework.stereotype.Component;

import javax.jws.WebService;

/**
 * @description:
 * @author: youcong
 */
@WebService(serviceName = "userService",//对外发布的服务名
        targetNamespace = "http://service.cxf.example.yc.com/",//指定你想要的名称空间，通常使用使用包名反转
        endpointInterface = "com.yc.example.cxf.service.UserService")
@Component
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(String email, String username, String password) {
        return 0;
    }
}
