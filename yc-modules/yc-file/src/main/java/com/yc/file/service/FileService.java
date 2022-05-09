package com.yc.file.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yc.common.core.base.dto.file.FileAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.file.FilePageReqDTO;
import com.yc.common.core.base.entity.file.FileEntity;

/**
 * @description:
 * @author: youcong
 */
public interface FileService extends IService<FileEntity> {


    /**
     * 列表分页查询
     *
     * @param reqDTO
     * @return
     */
    IPage<FileEntity> queryFilePageList(FilePageReqDTO reqDTO);

    /**
     * 新增或修改文件
     *
     * @param reqDTO
     * @return
     */
    int saveOrUpdate(FileAddOrUpdateReqDTO reqDTO);
}
