package com.yc.admin.service;

import com.yc.common.core.base.dto.common.OperateLog;

/**
 * @description:
 * @author: youcong
 */
public interface OperateLogService {
    /**
     * 操作日志添加
     *
     * @param operLog
     * @return
     */
    OperateLog add(OperateLog operLog);
}
