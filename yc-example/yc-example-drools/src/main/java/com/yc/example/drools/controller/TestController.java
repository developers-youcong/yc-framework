package com.yc.example.drools.controller;

import com.yc.example.drools.dto.CouponReqDTO;
import com.yc.example.drools.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {

    @Autowired
    private RuleService ruleService;

    @GetMapping("/test")
    public String test(int type) {
        CouponReqDTO reqDTO = new CouponReqDTO();
        reqDTO.setCouponType(type);
        int count = ruleService.executeCoupon(reqDTO);
        return String.valueOf(count);
    }
}
