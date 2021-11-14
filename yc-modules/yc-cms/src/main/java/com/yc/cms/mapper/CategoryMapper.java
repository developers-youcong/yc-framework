package com.yc.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.entity.cms.CategoryEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 分类
 * @author: youcong
 * @time: 2021/9/20 20:11
 */
@Repository
public interface CategoryMapper extends BaseMapper<CategoryEntity> {

    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<CategoryEntity> selectCategoryPageList(Page page, @Param("param") CategoryPageReqDTO reqDTO);

}
