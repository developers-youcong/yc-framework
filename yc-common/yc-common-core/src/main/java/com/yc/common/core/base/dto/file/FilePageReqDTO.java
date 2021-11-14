package com.yc.common.core.base.dto.file;

import com.yc.common.core.base.dto.base.PageParam;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/28 20:31
 */
@Data
public class FilePageReqDTO extends PageParam {
    private String fileName;
}
