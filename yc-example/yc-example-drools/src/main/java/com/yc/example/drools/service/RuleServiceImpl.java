package com.yc.example.drools.service;

import com.yc.example.drools.dto.CouponReqDTO;
import com.yc.example.drools.vo.CouponVO;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class RuleServiceImpl implements RuleService {
    //@Autowired
    //private KieContainer kieContainer;

    @Autowired
    private KieSession kieSession;

    @Override
    public int executeCoupon(CouponReqDTO reqDTO) {
        int count = 0;
        // KieSession kieSession = kieContainer.newKieSession();
        try {
            CouponVO vo = new CouponVO();
            kieSession.insert(reqDTO);
            kieSession.insert(vo);
            count = kieSession.fireAllRules();
            System.out.println("规则执行第" + count + "次，执行结果为:" + vo.getResult());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }
}
