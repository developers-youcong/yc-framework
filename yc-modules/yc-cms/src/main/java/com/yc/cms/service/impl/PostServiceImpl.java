package com.yc.cms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.cms.mapper.PostMapper;
import com.yc.cms.service.PostService;
import com.yc.common.core.base.dto.cms.PostPageReqDTO;
import com.yc.common.core.base.entity.cms.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:06
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, PostEntity> implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Override
    public IPage<PostEntity> queryPostPageList(PostPageReqDTO reqDTO) {
        Page<PostEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return postMapper.selectPostPageList(page, reqDTO);
    }
}
