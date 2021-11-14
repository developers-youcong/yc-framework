package com.yc.security.config;

import cn.dev33.satoken.action.SaTokenActionDefaultImpl;
import cn.dev33.satoken.util.SaFoxUtil;
import org.springframework.stereotype.Component;

/**
 * 继承Sa-Token行为Bean默认实现, 重写部分逻辑
 */
@Component
public class MySaTokenAction extends SaTokenActionDefaultImpl {
    // 重写token生成策略
    @Override
    public String createToken(Object loginId, String loginType) {
        return SaFoxUtil.getRandomString(36);    // 随机36位字符串
    }
}

