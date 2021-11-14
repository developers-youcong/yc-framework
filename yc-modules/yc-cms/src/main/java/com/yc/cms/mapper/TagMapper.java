package com.yc.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.dto.cms.TagPageReqDTO;
import com.yc.common.core.base.entity.cms.CategoryEntity;
import com.yc.common.core.base.entity.cms.TagEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 标签
 * @author: youcong
 * @time: 2021/9/20 20:14
 */
@Repository
public interface TagMapper extends BaseMapper<TagEntity> {

    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<TagEntity> selectTagPageList(Page page, @Param("param") TagPageReqDTO reqDTO);

}
