package com.yc.cms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.cms.PostPageReqDTO;
import com.yc.common.core.base.entity.cms.PostEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 文章
 * @author: youcong
 * @time: 2021/9/20 20:01
 */
@Repository
public interface PostMapper extends BaseMapper<PostEntity> {


    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<PostEntity> selectPostPageList(Page page, @Param("param") PostPageReqDTO reqDTO);

}
