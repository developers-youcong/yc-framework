package com.yc.example.drools.service;

import com.yc.example.drools.dto.CouponReqDTO;

/**
 * @description:
 * @author: youcong
 */
public interface RuleService {
    int executeCoupon(CouponReqDTO reqDTO);
}
