package com.yc.common.core.base.dto.cms;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 19:38
 */
@Data
public class TagAddOrUpdateReqDTO {
    private Long tagId;

    private String tagName;

    private Long companyId;
}
