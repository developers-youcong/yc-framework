package com.yc.common.core.base.utils.email;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @description:
 * @author: youcong
 */

public class MailUtil {

    public static void sendMail(String email, String emailMsg)
            throws MessagingException {

        String emailProtocol = "SMTP";
        String emailAccount = "email account";
        String emailPassword = "email account pwd";
        String emailSMTPHost = "smtp.xxxx.com";
        String smtpPort = "465";
        String emailTitle = "YC-Framework邮箱服务";
        String emailAuth = "true";
        String emailSSLFactory = "javax.net.ssl.SSLSocketFactory";
        String emailFallback = "false";

        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", emailProtocol);
        props.setProperty("mail.host", emailSMTPHost);
        props.setProperty("mail.smtp.auth", emailAuth);// 指定验证为true
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", emailSSLFactory);
        props.setProperty("mail.smtp.socketFactory.fallback", emailFallback);
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        // 创建验证器
        Authenticator auth = new Authenticator() {
            @Override
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailAccount, emailPassword);
            }
        };
        //创建会话对象
        Session session = Session.getInstance(props, auth);
        //创建一个Message，它相当于是邮件内容
        Message message = new MimeMessage(session);
        // 设置发送者
        message.setFrom(new InternetAddress(emailAccount));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(email));
        //设置发送方式与接收者
        message.setSubject(emailTitle);
        //邮件正文
        message.setContent(emailMsg, "text/html;charset=utf-8");
        //创建 Transport用于将邮件发送
        Transport.send(message);
    }

}
