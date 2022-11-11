package com.yc.example.liteflow.controller;

import com.yc.example.liteflow.dto.ProcessReqDTO;
import com.yc.example.liteflow.slot.ProcessSlot;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class ProccessController {
    @Resource
    private FlowExecutor flowExecutor;

    @GetMapping("/test")
    public String test() {
        ProcessReqDTO processReqDTO = getProcessReqDTO();
        LiteflowResponse response = flowExecutor.execute2Resp("chain1", processReqDTO, ProcessSlot.class);
        System.out.println("isSuccess:" + response.isSuccess());
        System.out.println("slot:" + response.getSlot());
        return response.getMessage();
    }

    private ProcessReqDTO getProcessReqDTO() {
        return ProcessReqDTO.builder().
                processId(1L)
                .processName("流程1号")
                .processStatus(0)
                .build();
    }
}
