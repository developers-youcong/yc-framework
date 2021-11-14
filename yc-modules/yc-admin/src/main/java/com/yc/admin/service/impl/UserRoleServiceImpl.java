package com.yc.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.admin.mapper.UserRoleMapper;
import com.yc.admin.service.UserRoleService;
import com.yc.common.core.base.entity.admin.UserRoleEntity;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 21:14
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRoleEntity> implements UserRoleService {
}
