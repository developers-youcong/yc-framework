package com.yc.common.core.base.dto.plugins.robot;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class PerceptionReqDTO {
    private InputTextReqDTO inputText;
    private InputImageReqDTO inputImage;
    private SelfInfoReqDTO selfInfo;
}
