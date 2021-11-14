package com.yc.common.core.base.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 21:14
 */
public class JbcryptUtil {
    /**
     * 密码加密
     */
    public static String bcryptPwd(String pwd) {
        return BCrypt.hashpw(pwd, BCrypt.gensalt(12));
    }

    /**
     * 验证密码正确性
     * pwd 用户原来的密码    hashed用户新密码
     */
    public static boolean checkPwd(String pwd, String hashed) {
        try {
            return BCrypt.checkpw(pwd, hashed);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
