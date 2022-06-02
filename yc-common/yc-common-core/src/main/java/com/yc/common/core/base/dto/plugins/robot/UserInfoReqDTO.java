package com.yc.common.core.base.dto.plugins.robot;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class UserInfoReqDTO {
    private String apiKey;
    private String userId = "robot";
}
