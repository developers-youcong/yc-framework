package com.yc.example.cxf.service;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @description:
 * @author: youcong
 */
@WebService(targetNamespace = "http://service.cxf.example.yc.com/")
public interface UserService {


    /**
     * 添加用户
     *
     * @param email
     * @param username
     * @param password
     * @return
     */
    int addUser(@WebParam(name = "email") String email, @WebParam(name = "username") String username, @WebParam(name = "password") String password);

}
