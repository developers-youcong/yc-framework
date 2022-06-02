package com.yc.admin.service.impl;

import com.yc.admin.service.OperateLogService;
import com.yc.common.core.base.dto.common.OperateLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class OperateLogServiceImpl implements OperateLogService {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public OperateLog add(OperateLog operLog) {
        return mongoTemplate.save(operLog);
    }
}
