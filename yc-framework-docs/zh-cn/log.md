# 日志模块化

## 一、导入依赖
间接引用(security包含log依赖):
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-security</artifactId>
</dependency>

```
或直接引用:
```
<dependency>
    <groupId>com.yc.framework</groupId>
    <artifactId>yc-common-log</artifactId>
</dependency>

```

## 二、使用
在对应的@RequestMapping或@PostMapping下加如下注解即可:
```
    @Log("接口功能介绍")

```

案例(登录接口):
```
    @PostMapping("/auth/login")
    @ApiOperation("登录")
    @Log("登录")
    public ResultBody login(@RequestBody UserAuthInfoReqDTO reqDTO) {
        if (StrUtil.isEmpty(reqDTO.getAccount()) || StrUtil.isEmpty(reqDTO.getPassword()) || reqDTO.getType() == null) {
            return ResultBody.fail(ResultCode.ILLEGAL_PARAMETER_ERROR.getCode(), ResultCode.ILLEGAL_PARAMETER_ERROR.getMsg());
        }
        Map<String, Object> resultMap = userAuthService.loginHandle(reqDTO);
        String flag = resultMap.get(AuthConst.FLAG).toString();
        if (AuthConst.FLAG_ZERO_VAL.equals(flag)) {
            return ResultBody.fail(ResultCode.USER_NO_EXIST_ERROR.getCode(), ResultCode.USER_NO_EXIST_ERROR.getMsg());
        }
        if (AuthConst.FLAG_ONE_VAL.equals(flag)) {
            return ResultBody.fail(ResultCode.USER_OR_PASSWD_ERROR.getCode(), ResultCode.USER_OR_PASSWD_ERROR.getMsg());
        }
        if (AuthConst.FLAG_TWO_VAL.equals(flag)) {
            String ID = resultMap.get(AuthConst.ID).toString();
            StpUtil.login(ID);
            return ResultBody.success(resultMap);
        }
        return ResultBody.success();
    }


```

源代码示例:
https://github.com/developers-youcong/yc-framework/tree/main/yc-example/yc-example-log
