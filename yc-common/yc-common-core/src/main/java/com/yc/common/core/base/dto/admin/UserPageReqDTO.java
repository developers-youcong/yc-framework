package com.yc.common.core.base.dto.admin;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/10/3 14:10
 */
@Data
public class UserPageReqDTO extends PageParam {

    private String nickName;
}
