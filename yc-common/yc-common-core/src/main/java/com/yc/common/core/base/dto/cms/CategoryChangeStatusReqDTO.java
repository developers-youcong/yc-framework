package com.yc.common.core.base.dto.cms;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 18:17
 */
@Data
public class CategoryChangeStatusReqDTO {

    private Long categoryId;

    private Integer status;
}
