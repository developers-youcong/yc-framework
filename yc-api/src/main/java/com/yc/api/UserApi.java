package com.yc.api;

import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.dto.auth.UserIdReqDTO;
import com.yc.common.core.base.result.RespBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@FeignClient(contextId = "userApi", name = ApplicationConst.AUTH)
public interface UserApi {
    /**
     * 获取用户对应的角色菜单
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getPerm")
    RespBody<List<String>> getPerm(@RequestBody UserIdReqDTO reqDTO);

    /**
     * 获取用户对应的角色
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/auth/getRole")
    RespBody<List<String>> getRole(@RequestBody UserIdReqDTO reqDTO);
}
