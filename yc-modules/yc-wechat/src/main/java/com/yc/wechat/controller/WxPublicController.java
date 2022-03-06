package com.yc.wechat.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.config.impl.WxMpDefaultConfigImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Slf4j
@Api(tags = {"微信生态-微信公众号"}, description = "微信生态-微信公众号")
@RequestMapping("/wx_public")
public class WxPublicController {

    @Value("${wx_public.app_id}")
    private String appId;

    @Value("${wx_public.app_secret}")
    private String appSecret;

    @Value("${wx_public.token}")
    private String token;

    @Value("${wx_public.aes_key}")
    private String aesKey;

    public static WxMpService wxService = new WxMpServiceImpl();

    public static WxMpService getWxService() {
        return wxService;
    }

    @PostMapping("/")
    public void index(HttpServletRequest request, HttpServletResponse response) {
        WxMpDefaultConfigImpl config = new WxMpDefaultConfigImpl();
        config.setAppId(appId); // 设置微信公众号的appid
        config.setSecret(appSecret); // 设置微信公众号的app corpSecret
        config.setToken(token); // 设置微信公众号的token
        config.setAesKey(aesKey); // 设置微信公众号的EncodingAESKey
        getWxService().setWxMpConfigStorage(config);
        PrintWriter out = null;
        // 调用核心业务类方法接收消息并处理消息
        String respMsg = "hello world";
        try {
            request.setCharacterEncoding("UTF-8");
            response.setContentType("text/html;charset=UTF-8");
            out = response.getWriter();
            out.print(respMsg);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }
}
