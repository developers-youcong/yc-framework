package com.yc.example.liteflow.dto;


import com.yomahub.liteflow.slot.Slot;
import lombok.Builder;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
@Builder
public class ProcessReqDTO extends Slot {
    private Long processId;
    private String processName;
    private Integer processStatus;
}
