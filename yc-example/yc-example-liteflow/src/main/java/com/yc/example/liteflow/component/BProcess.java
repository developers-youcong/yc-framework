package com.yc.example.liteflow.component;

import com.yc.example.liteflow.slot.ProcessSlot;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component("b")
public class BProcess extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("第二道流程");
        ProcessSlot processSlot = this.getSlot();
        if (processSlot.getProcessId() == null) {
            throw new RuntimeException("流程ID为空");
        }
    }
}
