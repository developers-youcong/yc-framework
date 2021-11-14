package com.yc.common.core.base.dto.cms;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 18:06
 */
@Data
public class CategoryAddOrUpdateReqDTO {

    private Long categoryId;

    private String categoryName;

    private Long companyId;
}
