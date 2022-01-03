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

    /**
     * 每次登录时触发
     */
    @Override
    public void doLogin(String s, Object o, SaLoginModel saLoginModel) {
        log.info("每次登录时触发");
    }

    /**
     * 每次注销时触发
     */
    @Override
    public void doLogout(String s, Object o, String s1) {
        log.info("每次注销时触发");
    }

    @Override
    public void doLogoutByLoginId(String s, Object o, String s1, String s2) {

    }

    /**
     * 每次注销时触发
     */
    @Override
    public void doReplaced(String loginType, Object loginId, String s1, String s2) {
        log.info("每次注销时触发");
    }

    /**
     * 每次被封禁时触发
     */
    @Override
    public void doDisable(String loginType, Object loginId, long disableTime) {
        log.info("每次被封禁时触发");
    }

    /**
     * 每次被解封时触发
     */
    @Override
    public void doUntieDisable(String loginType, Object loginId) {
        log.info("每次被解封时触发");
    }

    /**
     * 每次创建Session时触发
     */
    @Override
    public void doCreateSession(String id) {
        log.info("每次创建Session时触发:" + id);
    }

    /**
     * 每次注销Session时触发
     */
    @Override
    public void doLogoutSession(String id) {
        log.info("每次注销Session时触发:" + id);
    }
}

