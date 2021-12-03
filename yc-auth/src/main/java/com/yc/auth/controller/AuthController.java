package com.yc.auth.controller;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.StrUtil;
import com.yc.auth.service.UserAuthService;
import com.yc.common.core.base.constant.AuthConst;
import com.yc.common.core.base.dto.auth.LogoutReqDTO;
import com.yc.common.core.base.dto.auth.UserAuthInfoReqDTO;
import com.yc.common.core.base.enums.ResultCode;
import com.yc.common.core.base.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:11
 */
@RestController
@Slf4j
@Api(tags = {"认证管理"}, description = "认证管理")
public class AuthController {

    @Autowired
    private UserAuthService userAuthService;

    /**
     * 登录
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/login")
    @ApiOperation("登录")
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

    /**
     * 登录状态
     *
     * @return
     */
    @PostMapping("/auth/isLogin")
    @ApiOperation("登录状态")
    public ResultBody isLogin() {
        return ResultBody.success(StpUtil.isLogin());
    }

    /**
     * 获取Token信息
     *
     * @return
     */
    @PostMapping("/auth/getTokenInfo")
    @ApiOperation("获取Token信息")
    public ResultBody getTokenInfo() {
        return ResultBody.success(StpUtil.getTokenInfo());
    }

    /**
     * 退出
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/logout")
    @ApiOperation("退出")
    public ResultBody logout(@RequestBody LogoutReqDTO reqDTO) {
        StpUtil.logoutByLoginId(reqDTO.getUserId());
        return ResultBody.success();
    }


}
