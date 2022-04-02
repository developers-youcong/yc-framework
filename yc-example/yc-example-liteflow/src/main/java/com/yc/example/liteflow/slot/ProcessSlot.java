package com.yc.example.liteflow.slot;


import com.yomahub.liteflow.entity.data.AbsSlot;
import lombok.Data;

/**
 * @description:
 * @author: youcong
 */
@Data
public class ProcessSlot extends AbsSlot {
    private Long processId;
    private String processName;
    private Integer processStatus;
}
