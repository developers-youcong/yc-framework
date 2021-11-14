package com.yc.auth.mapper;

import com.yc.common.core.base.vo.auth.UserAuthVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 认证
 * @author: youcong
 * @time: 2021/9/20 21:51
 */
@Repository
public interface AuthMapper {

    /**
     * 根据不同账户及其账户类型获取对应的用户信息
     *
     * @param type
     * @param account
     * @return
     */
    UserAuthVO selectUserAuthInfo(@Param("type") Integer type, @Param("account") String account);

}
