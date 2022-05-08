package com.yc.file.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.common.core.base.dto.file.FileAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.file.FilePageReqDTO;
import com.yc.common.core.base.entity.file.FileEntity;
import com.yc.file.mapper.FileMapper;
import com.yc.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, FileEntity> implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public IPage<FileEntity> queryFilePageList(FilePageReqDTO reqDTO) {
        Page<FileEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return fileMapper.selectFilePageList(page, reqDTO);
    }

    @Override
    public int saveOrUpdate(FileAddOrUpdateReqDTO reqDTO) {
        return handleFileAddOrUpdateData(reqDTO);
    }

    /**
     * 处理新增或修改的文件存储对象
     *
     * @param reqDTO
     * @return
     */
    private int handleFileAddOrUpdateData(FileAddOrUpdateReqDTO reqDTO) {
        int count = 0;
        FileEntity fileEntity = new FileEntity();
        if (StrUtil.isEmpty(reqDTO.getId())) {
            fileEntity.setId(IdUtil.simpleUUID());
            fileEntity.setCompanyId(reqDTO.getCompanyId());
            fileEntity.setCreateTime(DateUtil.date());
            fileEntity.setUpdateTime(DateUtil.date());
            fileEntity.setFileName(reqDTO.getFileName());
            fileEntity.setFileSize(reqDTO.getFileSize());
            fileEntity.setFileStatus(reqDTO.getFileStatus());
            fileEntity.setFileType(reqDTO.getFileType());
            fileEntity.setFileUrl(reqDTO.getFileUrl());
            fileEntity.setFilePassword(reqDTO.getFilePassword());
            fileEntity.setUploadId(reqDTO.getUploadId());
            count = fileMapper.insert(fileEntity);
        } else {
            fileEntity.setId(IdUtil.simpleUUID());
            fileEntity.setCompanyId(reqDTO.getCompanyId());
            fileEntity.setCreateTime(DateUtil.date());
            fileEntity.setUpdateTime(DateUtil.date());
            fileEntity.setFileName(reqDTO.getFileName());
            fileEntity.setFileSize(reqDTO.getFileSize());
            fileEntity.setFileStatus(reqDTO.getFileStatus());
            fileEntity.setFileType(reqDTO.getFileType());
            fileEntity.setFileUrl(reqDTO.getFileUrl());
            fileEntity.setFilePassword(reqDTO.getFilePassword());
            fileEntity.setUploadId(reqDTO.getUploadId());
            count = fileMapper.updateById(fileEntity);
        }
        return count;
    }
}
