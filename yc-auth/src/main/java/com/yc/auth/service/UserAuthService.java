package com.yc.auth.service;

import com.yc.common.core.base.dto.auth.UserAuthInfoReqDTO;
import com.yc.common.core.base.dto.auth.UserIdReqDTO;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: youcong
 */
public interface UserAuthService {

    /**
     * 登录认证逻辑处理
     *
     * @param reqDTO
     * @return
     */
    Map<String, Object> loginHandle(UserAuthInfoReqDTO reqDTO);

    /**
     * 获取用户ID对应的角色
     *
     * @param reqDTO
     * @return
     */
    List<String> queryUserIdByRole(UserIdReqDTO reqDTO);

    /**
     * 获取用户ID对应的角色菜单权限
     *
     * @param reqDTO
     * @return
     */
    List<String> queryUserIdByPerm(UserIdReqDTO reqDTO);
}
