package com.yc.admin.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.yc.admin.service.CompanyService;
import com.yc.common.core.base.dto.admin.CompanyAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.admin.CompanyDelReqDTO;
import com.yc.common.core.base.dto.admin.CompanyOneReqDTO;
import com.yc.common.core.base.dto.admin.CompanyPageReqDTO;
import com.yc.common.core.base.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/19 20:53
 */
@RestController
@Slf4j
@Api(tags = {"后台管理-公司管理"}, description = "后台管理-公司管理")
public class CompanyController {

    @Autowired
    private CompanyService companyService;


    /**
     * 获取公司详细信息
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/company/queryCompanyInfo")
    @ApiOperation("获取公司详细信息")
    public ResultBody queryCompanyInfo(@RequestBody CompanyOneReqDTO reqDTO) {
        log.info("/company/queryCompanyInfo:" + reqDTO);
        return ResultBody.success(companyService.queryCompanyInfo(reqDTO));
    }

    /**
     * 获取公司列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/company/queryPageList")
    @ApiOperation("获取公司列表")
    public ResultBody queryPageList(@RequestBody CompanyPageReqDTO reqDTO) {
        log.info("/company/queryPageList:" + reqDTO);
        return ResultBody.success(companyService.queryCompanyPageList(reqDTO));
    }

    /**
     * 新增或修改公司信息
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/company/saveOrUpdate")
    @ApiOperation("新增或修改公司信息")
    public ResultBody saveOrUpdate(@RequestBody CompanyAddOrUpdateReqDTO reqDTO) {
        log.info("/company/saveOrUpdate:" + reqDTO);
        return ResultBody.success(companyService.saveOrUpdateCompanyInfo(reqDTO));
    }

    /**
     * 删除公司信息
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/company/del")
    @ApiOperation(("删除公司信息"))
    public ResultBody del(@RequestBody CompanyDelReqDTO reqDTO) {
        log.info("/company/del:" + reqDTO);
        return ResultBody.success(companyService.del(reqDTO));
    }
}
