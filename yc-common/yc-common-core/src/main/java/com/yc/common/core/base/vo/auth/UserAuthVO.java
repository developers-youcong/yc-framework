package com.yc.common.core.base.vo.auth;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 22:06
 */
@Data
public class UserAuthVO {

    private String id;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private String nickName;

    private Long companyId;

    private Integer sex;

    private Integer status;
}
