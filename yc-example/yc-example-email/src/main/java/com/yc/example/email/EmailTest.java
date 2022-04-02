package com.yc.example.email;

import com.yc.common.core.base.utils.email.MailUtil;

/**
 * @description:
 * @author: youcong
 */
public class EmailTest {
    public static void main(String[] args) throws Exception {
        MailUtil.sendMail("xx@163.com", "it is a test");
    }
}
