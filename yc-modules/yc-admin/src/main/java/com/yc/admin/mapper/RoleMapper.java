package com.yc.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.admin.RolePageReqDTO;
import com.yc.common.core.base.entity.admin.RoleEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 角色
 * @author: youcong
 * @time: 2021/9/20 21:05
 */
@Repository
public interface RoleMapper extends BaseMapper<RoleEntity> {

    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<RoleEntity> selectRolePageList(Page page, @Param("param") RolePageReqDTO reqDTO);

}
