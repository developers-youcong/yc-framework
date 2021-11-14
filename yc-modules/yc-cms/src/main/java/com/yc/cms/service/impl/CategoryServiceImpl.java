package com.yc.cms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.cms.mapper.CategoryMapper;
import com.yc.cms.service.CategoryService;
import com.yc.common.core.base.constant.CategoryConst;
import com.yc.common.core.base.dto.cms.CategoryAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.cms.CategoryChangeStatusReqDTO;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.entity.cms.CategoryEntity;
import com.yc.common.core.base.entity.cms.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:12
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryEntity> implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public IPage<CategoryEntity> queryCategoryPageList(CategoryPageReqDTO reqDTO) {
        Page<PostEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return categoryMapper.selectCategoryPageList(page, reqDTO);
    }

    @Override
    public int saveOrUpdateCategory(CategoryAddOrUpdateReqDTO reqDTO) {
        return handleCategoryAddOrUpdate(reqDTO);
    }

    @Override
    public int changeCategoryStatus(CategoryChangeStatusReqDTO reqDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(reqDTO.getCategoryId());
        if (CategoryConst.CATEGORY_STATUS_FORBID == reqDTO.getStatus()) {
            categoryEntity.setStatus(CategoryConst.CATEGORY_STATUS_FORBID);
        }
        if (CategoryConst.CATEGORY_STATUS_DEL == reqDTO.getStatus()) {
            categoryEntity.setStatus(CategoryConst.CATEGORY_STATUS_DEL);
        }
        return categoryMapper.updateById(categoryEntity);
    }

    private int handleCategoryAddOrUpdate(CategoryAddOrUpdateReqDTO reqDTO) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (reqDTO.getCategoryId() == 0) {
            categoryEntity.setCategoryName(reqDTO.getCategoryName());
            categoryEntity.setCompanyId(reqDTO.getCompanyId());
            categoryEntity.setStatus(CategoryConst.CATEGORY_STATUS_NORMAL);
            categoryEntity.setCreateTime(DateUtil.date());
            categoryEntity.setUpdateTime(DateUtil.date());
            return categoryMapper.insert(categoryEntity);
        } else {
            categoryEntity.setId(reqDTO.getCategoryId());
            categoryEntity.setCategoryName(reqDTO.getCategoryName());
            categoryEntity.setCompanyId(reqDTO.getCompanyId());
            categoryEntity.setStatus(CategoryConst.CATEGORY_STATUS_NORMAL);
            categoryEntity.setCreateTime(DateUtil.date());
            categoryEntity.setUpdateTime(DateUtil.date());
            return categoryMapper.updateById(categoryEntity);
        }
    }
}
