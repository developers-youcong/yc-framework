package com.yc.example.liteflow.component;

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
    }
}
