# 邮件

## 一、导入依赖
```
<dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
</dependency>

```

## 二、配置文件
```
emailProtocol=SMTP
emailAccount=xx@163.com
emailPassword=xxxxxx
emailSMTPHost=smtp.163.com
smtpPort=465
emailTitle=邮箱服务
emailAuth=true
emailSSLFactory=javax.net.ssl.SSLSocketFactory
emailFallback=false

```

## 三、核心代码
```
@Component
@PropertySource(value = {"classpath:email.properties"}, encoding = "utf-8")
public class MailUtil {

    @Autowired
    private Environment env;

    private static MailUtil mailUtil;

    @PostConstruct
    public void init() {
        mailUtil = this;
        mailUtil.env = env;
    }

    public static void sendMail(String email, String emailMsg)
            throws MessagingException {

        //获取email配置文件相关信息
        String emailProtocol = mailUtil.env.getProperty("emailProtocol");
        String emailAccount = mailUtil.env.getProperty("emailAccount");
        String emailPassword = mailUtil.env.getProperty("emailPassword");
        String emailSMTPHost = mailUtil.env.getProperty("emailSMTPHost");
        String smtpPort = mailUtil.env.getProperty("smtpPort");
        String emailTitle = mailUtil.env.getProperty("emailTitle");
        String emailAuth = mailUtil.env.getProperty("emailAuth");
        String emailSSLFactory = mailUtil.env.getProperty("emailSSLFactory");
        String emailFallback = mailUtil.env.getProperty("emailFallback");

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

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-email