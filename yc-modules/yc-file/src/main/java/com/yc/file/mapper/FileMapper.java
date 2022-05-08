package com.yc.file.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yc.common.core.base.dto.file.FilePageReqDTO;
import com.yc.common.core.base.entity.file.FileEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description: 文件
 * @author: youcong
 */
@Repository
public interface FileMapper extends BaseMapper<FileEntity> {

    /**
     * 分页列表查询
     *
     * @param page
     * @param reqDTO
     * @return
     */
    IPage<FileEntity> selectFilePageList(Page page, @Param("param") FilePageReqDTO reqDTO);

}
