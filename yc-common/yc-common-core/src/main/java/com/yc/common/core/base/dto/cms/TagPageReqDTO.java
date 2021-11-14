package com.yc.common.core.base.dto.cms;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 19:35
 */
@Data
public class TagPageReqDTO extends PageParam {
    private String tagName;
}
