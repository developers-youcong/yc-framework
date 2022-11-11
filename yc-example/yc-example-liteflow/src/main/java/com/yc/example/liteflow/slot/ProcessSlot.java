package com.yc.example.liteflow.slot;


import com.yomahub.liteflow.slot.Slot;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class ProcessSlot extends Slot {
    private Long processId;
    private String processName;
    private Integer processStatus;
}
