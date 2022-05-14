package com.yc.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.admin.mapper.RoleMapper;
import com.yc.admin.service.RoleService;
import com.yc.common.core.base.constant.UserConst;
import com.yc.common.core.base.dto.admin.RoleAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.RoleDelReqDTO;
import com.yc.common.core.base.dto.admin.RolePageReqDTO;
import com.yc.common.core.base.entity.admin.RoleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, RoleEntity> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int saveOrUpdate(RoleAddOrUpdateReqDTO reqDTO) {
        return handleRoleSaveOrUpdate(reqDTO);
    }

    @Override
    public int del(RoleDelReqDTO reqDTO) {
        return roleMapper.deleteById(reqDTO.getRoleId());
    }

    @Override
    public IPage<RoleEntity> queryRolePageList(RolePageReqDTO reqDTO) {
        Page<RoleEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return roleMapper.selectRolePageList(page, reqDTO);
    }

    /**
     * 处理角色新增或修改详情
     *
     * @param reqDTO
     * @return
     */
    private int handleRoleSaveOrUpdate(RoleAddOrUpdateReqDTO reqDTO) {
        RoleEntity roleEntity = new RoleEntity();
        if (StrUtil.isEmpty(reqDTO.getRoleId())) {
            roleEntity.setId(IdUtil.simpleUUID());
            roleEntity.setRoleName(reqDTO.getRoleName());
            roleEntity.setCreateTime(DateUtil.date());
            roleEntity.setUpdateTime(DateUtil.date());
            roleEntity.setStatus(UserConst.ROLE_STATUS_ENABLE);
            return roleMapper.insert(roleEntity);
        } else {
            roleEntity.setId(reqDTO.getRoleId());
            roleEntity.setRoleName(reqDTO.getRoleName());
            roleEntity.setUpdateTime(DateUtil.date());
            return roleMapper.updateById(roleEntity);
        }
    }
}
