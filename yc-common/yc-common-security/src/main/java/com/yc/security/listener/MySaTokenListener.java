package com.yc.security.listener;

/**
 * @description:
 * @author: youcong
 */

import cn.dev33.satoken.listener.SaTokenListener;
import cn.dev33.satoken.stp.SaLoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * 自定义侦听器的实现
 */
@Component
@Slf4j
public class MySaTokenListener implements SaTokenListener {

    @Override
    public void doLogin(String loginType, Object loginId, String tokenValue, SaLoginModel loginModel) {
        System.out.println("---------- 每次登录时触发");
    }

    @Override
    public void doLogout(String loginType, Object loginId, String tokenValue) {
        System.out.println("---------- 每次注销时触发");
    }

    @Override
    public void doKickout(String loginType, Object loginId, String tokenValue) {
        System.out.println("---------- 每次被踢下线时触发");
    }

    @Override
    public void doReplaced(String loginType, Object loginId, String tokenValue) {
        System.out.println("---------- 每次被顶下线时触发");
    }

    @Override
    public void doDisable(String loginType, Object loginId, String service, int level, long disableTime) {
        System.out.println("----------  每次被封禁时触发");
    }

    @Override
    public void doUntieDisable(String loginType, Object loginId, String service) {
        System.out.println("---------- 每次被解封时触发");
    }

    @Override
    public void doCreateSession(String id) {
        System.out.println("---------- 每次创建Session时触发");
    }

    @Override
    public void doLogoutSession(String id) {
        System.out.println("---------- 每次注销Session时触发");
    }

    @Override
    public void doRenewTimeout(String tokenValue, Object loginId, long timeout) {
        System.out.println("---------- 每次Token续期时触发");
    }
}

