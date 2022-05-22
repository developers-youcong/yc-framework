package com.yc.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.admin.RoleAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.RoleDelReqDTO;
import com.yc.common.core.base.dto.admin.RolePageReqDTO;
import com.yc.common.core.base.entity.admin.RoleEntity;

/**
 * @description:
 * @author: youcong
 */
public interface RoleService extends IService<RoleEntity> {
    /**
     * 添加或修改
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdate(RoleAddOrUpdateReqDTO reqDTO);

    /**
     * 删除
     *
     * @param reqDTO
     * @return
     */
    int del(RoleDelReqDTO reqDTO);

    /**
     * 列表分页查询
     *
     * @param reqDTO
     * @return
     */
    IPage<RoleEntity> queryRolePageList(RolePageReqDTO reqDTO);
}
