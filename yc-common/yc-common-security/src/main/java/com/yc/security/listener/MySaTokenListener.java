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
    public void doLogin(String s, Object o, String s1, SaLoginModel saLoginModel) {
        log.info("登录触发");
    }

    @Override
    public void doLogout(String s, Object o, String s1) {
        log.info("注销触发");
    }

    @Override
    public void doKickout(String s, Object o, String s1) {
        log.info("每次被踢下线时触发");
    }

    @Override
    public void doReplaced(String s, Object o, String s1) {
        log.info("每次被顶下线时触发");
    }

    @Override
    public void doDisable(String s, Object o, long l) {
        log.info("每次被封禁时触发");
    }

    @Override
    public void doUntieDisable(String s, Object o) {
        log.info("每次被解封时触发");
    }

    @Override
    public void doCreateSession(String s) {
        log.info("每次创建Session时触发");
    }

    @Override
    public void doLogoutSession(String s) {
        log.info("每次注销Session时触发");
    }
}

