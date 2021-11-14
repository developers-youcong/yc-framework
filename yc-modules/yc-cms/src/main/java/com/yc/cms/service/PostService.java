package com.yc.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.cms.PostPageReqDTO;
import com.yc.common.core.base.entity.cms.PostEntity;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:05
 */
public interface PostService extends IService<PostEntity> {

    /**
     * 列表分页查询
     *      *
     * @param reqDTO
     * @return
     */
    IPage<PostEntity> queryPostPageList(PostPageReqDTO reqDTO);
}
