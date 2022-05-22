package com.yc.admin.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.admin.mapper.CompanyMapper;
import com.yc.admin.service.CompanyService;
import com.yc.common.core.base.dto.admin.CompanyAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.CompanyDelReqDTO;
import com.yc.common.core.base.dto.admin.CompanyOneReqDTO;
import com.yc.common.core.base.dto.admin.CompanyPageReqDTO;
import com.yc.common.core.base.entity.admin.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, CompanyEntity> implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public IPage<CompanyEntity> queryCompanyPageList(CompanyPageReqDTO reqDTO) {
        Page<CompanyEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return companyMapper.selectCompanyPageList(page, reqDTO);
    }

    @Override
    public int saveOrUpdateCompanyInfo(CompanyAddOrUpdateReqDTO reqDTO) {
        return handleCompanyAddOrUpdate(reqDTO);
    }

    /**
     * 处理新增/修改
     *
     * @param reqDTO
     * @return
     */
    private int handleCompanyAddOrUpdate(CompanyAddOrUpdateReqDTO reqDTO) {

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(reqDTO.getCompanyId());
        companyEntity.setCompanyName(reqDTO.getCompanyName());
        companyEntity.setCompanyCode(reqDTO.getCompanyCode());
        companyEntity.setContact(reqDTO.getContact());
        companyEntity.setPhone(reqDTO.getPhone());
        companyEntity.setAddress(reqDTO.getAddress());
        companyEntity.setUrl(reqDTO.getUrl());
        companyEntity.setEmail(reqDTO.getEmail());
        companyEntity.setCount(reqDTO.getCount());

        if (companyEntity.getId() == null || companyEntity.getId() == 0) {
            companyEntity.setCreateTime(DateUtil.date());
            companyEntity.setUpdateTime(DateUtil.date());
            //新增
            return companyMapper.insert(companyEntity);
        }

        if (companyEntity.getId() != null && companyEntity.getId() != 0) {
            companyEntity.setUpdateTime(DateUtil.date());
            //修改
            return companyMapper.updateById(companyEntity);
        }

        return 0;
    }

    @Override
    public int del(CompanyDelReqDTO reqDTO) {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setId(reqDTO.getCompanyId());
        companyEntity.setStatus(1);
        return companyMapper.updateById(companyEntity);
    }

    @Override
    public CompanyEntity queryCompanyInfo(CompanyOneReqDTO reqDTO) {
        return companyMapper.selectById(reqDTO.getId());
    }
}
