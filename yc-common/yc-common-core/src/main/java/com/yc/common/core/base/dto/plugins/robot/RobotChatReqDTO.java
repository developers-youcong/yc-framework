package com.yc.common.core.base.dto.plugins.robot;

import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class RobotChatReqDTO {
    private Integer reqType;

    private PerceptionReqDTO perception;

    private UserInfoReqDTO userInfo;
}
