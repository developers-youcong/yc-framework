package com.yc.example.liteflow.component;

import com.yc.example.liteflow.slot.ProcessSlot;
import com.yomahub.liteflow.core.NodeComponent;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component("c")
public class CProcess extends NodeComponent {
    @Override
    public void process() throws Exception {
        System.out.println("第三道流程");
        ProcessSlot processSlot = this.getSlot();
        System.out.println("result:" + processSlot);
    }
}
