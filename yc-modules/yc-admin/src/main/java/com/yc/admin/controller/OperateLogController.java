package com.yc.admin.controller;

import com.yc.admin.service.OperateLogService;
import com.yc.common.core.base.dto.common.OperateLog;
import com.yc.common.core.base.result.RespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Slf4j
@Api(tags = {"后台管理-操作日志管理"}, description = "后台管理-操作日志管理")
public class OperateLogController {

    @Autowired
    private OperateLogService operateLogService;

    @PostMapping("/operate_log/add")
    @ApiOperation("操作日志数据添加")
    public RespBody add(@RequestBody OperateLog operateLog) {
        return RespBody.success(operateLogService.add(operateLog));
    }
}
