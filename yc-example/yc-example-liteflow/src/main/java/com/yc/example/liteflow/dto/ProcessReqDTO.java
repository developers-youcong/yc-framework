package com.yc.example.liteflow.dto;

import com.yomahub.liteflow.entity.data.AbsSlot;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
@Builder
public class ProcessReqDTO extends AbsSlot {
    private Long processId;
    private String processName;
    private Integer processStatus;
}
