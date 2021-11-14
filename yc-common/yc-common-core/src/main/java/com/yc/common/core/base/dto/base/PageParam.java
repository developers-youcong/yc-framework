package com.yc.common.core.base.dto.base;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 22:25
 */
@Data
public class PageParam {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String orderCon;
    private String sortCon;
}
