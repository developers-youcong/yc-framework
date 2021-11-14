package com.yc.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.cms.*;
import com.yc.common.core.base.entity.cms.CategoryEntity;
import com.yc.common.core.base.entity.cms.TagEntity;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:16
 */
public interface TagService extends IService<TagEntity> {

    /**
     * 列表分页查询
     * *
     *
     * @param reqDTO
     * @return
     */
    IPage<TagEntity> queryTagPageList(TagPageReqDTO reqDTO);

    /**
     * 新增或修改标签
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdateTag(TagAddOrUpdateReqDTO reqDTO);


    /**
     * 改变分类状态(删除或禁用)
     *
     * @param reqDTO
     * @return
     */
    int changeTagStatus(TagChangeStatusReqDTO reqDTO);

}
