package com.yc.admin.controller;

import cn.hutool.core.util.StrUtil;
import com.yc.admin.service.UserService;
import com.yc.common.core.base.constant.UserConst;
import com.yc.common.core.base.dto.admin.*;
import com.yc.common.core.base.entity.admin.UserEntity;
import com.yc.common.core.base.result.RespBody;
import com.yc.common.core.base.utils.JbcryptUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Slf4j
@Api(tags = {"后台管理-用户管理"}, description = "后台管理-用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 获取用户列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/queryPageList")
    @ApiOperation("获取用户列表")
    public RespBody queryPageList(@RequestBody UserPageReqDTO reqDTO) {
        log.info("/user/queryPageList:" + reqDTO);
        return RespBody.success(userService.queryUserPageList(reqDTO));
    }

    /**
     * 新增或修改用
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/saveOrUpdate")
    @ApiOperation("新增或修改用户")
    public RespBody saveOrUpdate(@RequestBody UserAddOrUpdateReqDTO reqDTO) {
        log.info("/user/saveOrUpdate:" + reqDTO);
        return RespBody.success(userService.saveOrUpdateUser(reqDTO));
    }

    /**
     * 删除用户
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/del")
    @ApiOperation("删除用户")
    public RespBody del(@RequestBody UserDelReqDTO reqDTO) {
        log.info("/user/del");
        return RespBody.success(userService.changeUserStatus(reqDTO.getUserId(), UserConst.USER_STATUS_DEL));
    }

    /**
     * 禁用用户
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/forbid")
    @ApiOperation("禁用用户")
    public RespBody forbid(@RequestBody UserDelReqDTO reqDTO) {
        log.info("/user/forbid");
        return RespBody.success(userService.changeUserStatus(reqDTO.getUserId(), UserConst.USER_STATUS_FORBID));
    }


    /**
     * 获取用户信息
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/getById")
    @ApiOperation("获取用户信息")
    public RespBody getById(@RequestBody UserOneReqDTO reqDTO) {
        log.info("/user/getById");
        return RespBody.success(userService.selectUserOne(reqDTO));
    }


    /**
     * 验证旧密码是否正确
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/oldPwdValidate")
    @ApiOperation("验证旧密码是否正确")
    public RespBody oldPwdValidate(@RequestBody UserOldPwdValidReqDTO reqDTO) {
        log.info("/user/oldPwdValidate");
        UserEntity userEntity = userService.getById(reqDTO.getUserId());
        if (!StrUtil.isEmpty(userEntity.getId())) {
            if (JbcryptUtil.checkPwd(reqDTO.getOldPwd(), userEntity.getPassword())) {
                return RespBody.success(true);
            } else {
                return RespBody.success(false);
            }
        }
        return RespBody.success(false);
    }

    /**
     * 修改密码
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/user/changePwd")
    @ApiOperation("修改密码")
    public RespBody changePwd(@RequestBody UserChangePwdReqDTO reqDTO) {
        return RespBody.success(userService.changePwd(reqDTO));
    }
}
