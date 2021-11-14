package com.yc.cms.controller;

import com.yc.cms.service.TagService;
import com.yc.common.core.base.dto.cms.CategoryPageReqDTO;
import com.yc.common.core.base.dto.cms.TagAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.cms.TagChangeStatusReqDTO;
import com.yc.common.core.base.dto.cms.TagPageReqDTO;
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
 * @time: 2021/9/20 20:18
 */
@RestController
@Slf4j
@Api(tags = {"内容管理-标签管理"}, description = "内容管理-标签管理")
public class TagController {

    @Autowired
    private TagService tagService;

    /**
     * 获取标签列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/tag/queryPageList")
    @ApiOperation("获取标签列表")
    public ResultBody queryPageList(@RequestBody TagPageReqDTO reqDTO) {
        log.info("/tag/queryPageList:" + reqDTO);
        return ResultBody.success(tagService.queryTagPageList(reqDTO));
    }


    /**
     * 新增或修改标签
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/tag/saveOrUpdate")
    @ApiOperation("新增或修改标签")
    public ResultBody saveOrUpdate(@RequestBody TagAddOrUpdateReqDTO reqDTO) {
        log.info("/tag/saveOrUpdate:" + reqDTO);
        return ResultBody.success(tagService.saveOrUpdateTag(reqDTO));
    }


    /**
     * 标签状态修改(禁用/删除)
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/tag/changeTagStatus")
    @ApiOperation("标签状态修改(禁用/删除)")
    public ResultBody changeCategoryStatus(@RequestBody TagChangeStatusReqDTO reqDTO) {
        log.info("/tag/changeTagStatus:" + reqDTO);
        return ResultBody.success(tagService.changeTagStatus(reqDTO));
    }
}
