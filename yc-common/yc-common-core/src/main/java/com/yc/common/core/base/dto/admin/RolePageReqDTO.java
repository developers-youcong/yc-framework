package com.yc.common.core.base.dto.admin;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/10/3 17:47
 */
@Data
public class RolePageReqDTO extends PageParam {

    private String roleName;
}
