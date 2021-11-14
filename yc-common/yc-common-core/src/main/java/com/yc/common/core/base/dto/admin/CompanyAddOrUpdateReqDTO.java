package com.yc.common.core.base.dto.admin;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:27
 */
@Data
public class CompanyAddOrUpdateReqDTO {

    private Long companyId;

    private String companyName;

    private String companyCode;

    private String contact;

    private String phone;

    private String address;

    private String url;

    private String email;

    private Long count;
}
