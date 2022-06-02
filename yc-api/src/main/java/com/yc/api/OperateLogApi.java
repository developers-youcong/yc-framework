package com.yc.api;

import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.dto.common.OperateLog;
import com.yc.common.core.base.result.RespBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @description:
 * @author: youcong
 */
@FeignClient(contextId = "operateLogApi", name = ApplicationConst.ADMIN)
public interface OperateLogApi {
    @PostMapping("/operate_log/add")
    RespBody add(@RequestBody OperateLog operateLog);
}
