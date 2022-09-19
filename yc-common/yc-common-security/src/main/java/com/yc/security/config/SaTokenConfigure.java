package com.yc.security.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpInterface;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import com.yc.api.UserApi;
import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.dto.auth.UserIdReqDTO;
import com.yc.common.core.base.enums.RespCode;
import com.yc.common.core.base.result.RespBody;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 接口拦截器
 * @author: youcong
 */
@Configuration
@Slf4j
public class SaTokenConfigure implements WebMvcConfigurer, StpInterface {

    @Autowired
    private UserApi userApi;

    /**
     * 注册拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {
            //登录认证
            SaRouter.match("/**", () -> StpUtil.checkLogin());
            // 角色认证 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
            SaRouter.match("/company/**", () -> StpUtil.checkRoleOr("admin", "super-admin"));
            //权限认证
            SaRouter.match("/company/**", () -> StpUtil.checkPermission("company"));
            SaRouter.match("/user/**", () -> StpUtil.checkPermission("admin"));
            SaRouter.match("/role/**", () -> StpUtil.checkPermission("admin"));

        })).addPathPatterns("/**").excludePathPatterns(
                "/auth/**", "/operate_log/add", "/doc.html", "/webjars/**", "/swagger-resources", "/actuator/**");
    }

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.info("loginId:" + loginId + "||" + loginType);
        List<String> permList = new ArrayList<>();
        UserIdReqDTO permReq = new UserIdReqDTO();
        permReq.setUserId(handleUserId(loginId.toString()));
        RespBody<List<String>> resultBody = userApi.getPerm(permReq);
        if (RespCode.SELECT_SUCCESS.getCode().equals(resultBody.getCode())) {
            permList = resultBody.getData();
        }
        return permList;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.info("loginId:" + loginId + "||" + loginType);
        List<String> roleList = new ArrayList<>();
        UserIdReqDTO permReq = new UserIdReqDTO();
        permReq.setUserId(handleUserId(loginId.toString()));
        RespBody<List<String>> resultBody = userApi.getRole(permReq);
        if (RespCode.SELECT_SUCCESS.getCode().equals(resultBody.getCode())) {
            roleList = resultBody.getData();
        }
        return roleList;
    }

    /**
     * 处理用户ID
     *
     * @param userId
     * @return
     */
    private String handleUserId(String userId) {
        return userId.substring(userId.lastIndexOf(ApplicationConst.DEFAULT_FLAG) + 1).replace(ApplicationConst.DEFAULT_FLAG, ApplicationConst.NULL_STR);
    }
}
