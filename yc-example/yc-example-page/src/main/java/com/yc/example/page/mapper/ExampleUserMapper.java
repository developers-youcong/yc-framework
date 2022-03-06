package com.yc.example.page.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.admin.UserPageReqDTO;
import com.yc.common.core.base.entity.admin.UserEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 用户
 * @author: youcong
 */
@Repository
public interface ExampleUserMapper extends BaseMapper<UserEntity> {

    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<UserEntity> selectUserPageListExample(Page page, @Param("param") UserPageReqDTO reqDTO);


}
