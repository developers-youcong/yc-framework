package com.yc.cms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.cms.CategoryAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.cms.CategoryChangeStatusReqDTO;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.entity.cms.CategoryEntity;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:12
 */
public interface CategoryService extends IService<CategoryEntity> {

    /**
     * 列表分页查询
     * *
     *
     * @param reqDTO
     * @return
     */
    IPage<CategoryEntity> queryCategoryPageList(CategoryPageReqDTO reqDTO);

    /**
     * 新增或修改分类
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdateCategory(CategoryAddOrUpdateReqDTO reqDTO);


    /**
     * 改变分类状态(删除或禁用)
     *
     * @param reqDTO
     * @return
     */
    int changeCategoryStatus(CategoryChangeStatusReqDTO reqDTO);

}
