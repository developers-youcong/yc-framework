package com.yc.common.core.base.dto.cms;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/13 17:32
 */
@Data
public class PostPageReqDTO extends PageParam {
    private String postTitle;
}
