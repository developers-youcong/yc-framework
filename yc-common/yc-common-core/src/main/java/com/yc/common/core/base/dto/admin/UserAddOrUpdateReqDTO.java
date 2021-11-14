package com.yc.common.core.base.dto.admin;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/10/3 13:21
 */
@Data
public class UserAddOrUpdateReqDTO {

    private String userId;

    private String userName;

    private String password;

    private String email;

    private String phone;

    private String nickName;

    private Integer companyId;

    private Integer sex;
}
