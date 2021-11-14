package com.yc.common.core.base.dto.admin;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:24
 */
@Data
public class CompanyPageReqDTO extends PageParam {

    private String companyName;
}
