package com.yc.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.admin.mapper.CompanyMenuMapper;
import com.yc.admin.service.CompanyMenuService;
import com.yc.common.core.base.entity.admin.CompanyMenuEntity;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class CompanyMenuServiceImpl extends ServiceImpl<CompanyMenuMapper, CompanyMenuEntity> implements CompanyMenuService {
}
