package com.yc.common.core.base.dto.cms;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 19:39
 */
@Data
public class TagChangeStatusReqDTO {

    private Long tagId;

    private Integer status;
}
