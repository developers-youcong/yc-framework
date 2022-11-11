package com.yc.example.liteflow.component;

import com.yc.example.liteflow.dto.ProcessReqDTO;
import com.yc.example.liteflow.slot.ProcessSlot;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component("a")
public class AProcess extends NodeComponent {

    @Override
    public void process() {
        System.out.println("第一道流程");
        ProcessReqDTO req = this.getSlot().getRequestData();
    }
}