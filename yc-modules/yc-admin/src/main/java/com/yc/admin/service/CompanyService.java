package com.yc.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.admin.CompanyAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.CompanyDelReqDTO;
import com.yc.common.core.base.dto.admin.CompanyOneReqDTO;
import com.yc.common.core.base.dto.admin.CompanyPageReqDTO;
import com.yc.common.core.base.entity.admin.CompanyEntity;

/**
 * @description:
 * @author: youcong
 */
public interface CompanyService extends IService<CompanyEntity> {


    /**
     * 列表分页查询
     *
     * @param reqDTO
     * @return
     */
    IPage<CompanyEntity> queryCompanyPageList(CompanyPageReqDTO reqDTO);

    /**
     * 保存或更新公司信息
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdateCompanyInfo(CompanyAddOrUpdateReqDTO reqDTO);

    /**
     * 删除公司信息
     *
     * @param reqDTO
     * @return
     */
    int del(CompanyDelReqDTO reqDTO);

    /**
     * 查询公司详细信息
     *
     * @param reqDTO
     * @return
     */
    CompanyEntity queryCompanyInfo(CompanyOneReqDTO reqDTO);

}
