package com.yc.file.controller;

import cn.hutool.core.util.StrUtil;
import com.yc.common.core.base.dto.file.FileAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.file.FileDelReqDTO;
import com.yc.common.core.base.dto.file.FilePageReqDTO;
import com.yc.common.core.base.enums.RespCode;
import com.yc.common.core.base.result.RespBody;
import com.yc.common.core.base.utils.file.FileUtil;
import com.yc.file.service.FileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @description:
 * @author: youcong
 */
@RestController
@Slf4j
@Api(tags = {"文件管理"}, description = "文件管理")
public class FileController {

    @Autowired
    private FileService fileService;


    /**
     * 获取文件列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/file/queryFilePageList")
    @ApiOperation("文件管理-获取文件列表")
    public RespBody queryPageList(@RequestBody FilePageReqDTO reqDTO) {
        log.info("/file/queryFilePageList:" + reqDTO);
        return RespBody.success(fileService.queryFilePageList(reqDTO));
    }

    /**
     * 文件管理-上传文件(基于本地文件服务器)
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping("/file/upload")
    @ApiOperation("文件管理-上传文件(基于本地文件服务器)")
    public RespBody uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            return RespBody.fail(RespCode.ILLEGAL_PARAMETER_ERROR.getCode(), RespCode.ILLEGAL_PARAMETER_ERROR.getMsg());
        }
        return RespBody.success(FileUtil.uploadFile("127.0.0.1", "D:/usr/file/", "/home/tech", file));
    }

    /**
     * 文件管理-添加或修改
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/file/saveOrUpdate")
    @ApiOperation("文件管理-添加或修改")
    public RespBody saveOrUpdate(@RequestBody FileAddOrUpdateReqDTO reqDTO) {
        if (StrUtil.isEmpty(reqDTO.getFileUrl()) || reqDTO.getFileStatus() == null || reqDTO.getFileType() == null) {
            return RespBody.fail(RespCode.ILLEGAL_PARAMETER_ERROR.getCode(), RespCode.ILLEGAL_PARAMETER_ERROR.getMsg());
        }
        return RespBody.success(fileService.saveOrUpdate(reqDTO));
    }

    /**
     * 文件管理-删除
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/file/del")
    @ApiOperation("文件管理-删除")
    public RespBody del(@RequestBody FileDelReqDTO reqDTO) {
        return RespBody.success(fileService.removeById(reqDTO.getFileId()));
    }

}
