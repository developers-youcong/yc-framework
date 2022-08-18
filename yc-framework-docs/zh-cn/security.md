# 接口鉴权

## 一、导入依赖
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-security</artifactId>
</dependency>

```

引入该依赖至任意的微服务，对应的微服务自动开启接口鉴权，不登录就不能获取接口正确的响应。

## 二、接口鉴权核心源代码
核心鉴权框架采用Sa-Token，感兴趣的朋友可以了解一下。

Sa-Token官方文档:
https://sa-token.dev33.cn/doc/index.html

Sa-Token源代码:
https://github.com/dromara/sa-token

代码位置:
https://github.com/developers-youcong/yc-framework/tree/main/yc-common/yc-common-security

### 1.配置类
SaTokenConfigure.java
```
@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册Sa-Token的路由拦截器，并排除登录接口或其他可匿名访问的接口地址 (与注解拦截器无关)
        registry.addInterceptor(new SaRouteInterceptor()).addPathPatterns("/**").excludePathPatterns(
                "/cert/**","/auth/**", "/doc.html", "/webjars/**", "/swagger-resources");
    }
}
```

### 2.Action
MySaTokenAction.java
```
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

```

### 3.异常信息处理
OverallExceptionHandler.java
```
@RestControllerAdvice
@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
public class OverallExceptionHandler {

    @ExceptionHandler(value = NotLoginException.class)
    public ResultBody handUserExceptionHandler(NotLoginException e) {
        e.printStackTrace();
        // 判断场景值，定制化异常信息
        String message = "";
        if (e.getType().equals(NotLoginException.NOT_TOKEN)) {
            message = "未提供token";
        } else if (e.getType().equals(NotLoginException.INVALID_TOKEN)) {
            message = "token无效";
        } else if (e.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            message = "token已过期";
        } else if (e.getType().equals(NotLoginException.BE_REPLACED)) {
            message = "token已被顶下线";
        } else if (e.getType().equals(NotLoginException.KICK_OUT)) {
            message = "token已被踢下线";
        } else {
            message = "当前会话未登录";
        }
        return ResultBody.fail(ResultCode.TOKEN_ERROR.getCode(), message);
    }
}

```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-security