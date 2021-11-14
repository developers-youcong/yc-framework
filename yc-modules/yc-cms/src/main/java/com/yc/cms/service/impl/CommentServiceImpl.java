package com.yc.cms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.common.core.base.entity.cms.CommentEntity;
import com.yc.cms.mapper.CommentMapper;
import com.yc.cms.service.CommentService;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:15
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, CommentEntity> implements CommentService {
}
