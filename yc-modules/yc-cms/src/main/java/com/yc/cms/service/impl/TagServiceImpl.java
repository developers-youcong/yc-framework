package com.yc.cms.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yc.cms.mapper.TagMapper;
import com.yc.cms.service.TagService;
import com.yc.common.core.base.constant.CategoryConst;
import com.yc.common.core.base.dto.cms.TagAddOrUpdateReqDTO;
import com.yc.common.core.base.dto.cms.TagChangeStatusReqDTO;
import com.yc.common.core.base.dto.cms.TagPageReqDTO;
import com.yc.common.core.base.entity.cms.CategoryEntity;
import com.yc.common.core.base.entity.cms.TagEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:17
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, TagEntity> implements TagService {

    @Autowired
    private TagMapper tagMapper;

    @Override
    public IPage<TagEntity> queryTagPageList(TagPageReqDTO reqDTO) {
        Page<TagEntity> page = new Page<>(reqDTO.getPageNum(), reqDTO.getPageSize());
        return tagMapper.selectTagPageList(page, reqDTO);
    }

    @Override
    public int saveOrUpdateTag(TagAddOrUpdateReqDTO reqDTO) {
        return handleTagAddOrUpdate(reqDTO);
    }

    private int handleTagAddOrUpdate(TagAddOrUpdateReqDTO reqDTO) {
        TagEntity tagEntity = new TagEntity();
        if (reqDTO.getTagId() == 0) {
            tagEntity.setTagName(reqDTO.getTagName());
            tagEntity.setCompanyId(reqDTO.getCompanyId());
            tagEntity.setStatus(CategoryConst.CATEGORY_STATUS_NORMAL);
            tagEntity.setCreateTime(DateUtil.date());
            tagEntity.setUpdateTime(DateUtil.date());
            return tagMapper.insert(tagEntity);
        } else {
            tagEntity.setId(reqDTO.getTagId());
            tagEntity.setTagName(reqDTO.getTagName());
            tagEntity.setCompanyId(reqDTO.getCompanyId());
            tagEntity.setStatus(CategoryConst.CATEGORY_STATUS_NORMAL);
            tagEntity.setCreateTime(DateUtil.date());
            tagEntity.setUpdateTime(DateUtil.date());
            return tagMapper.updateById(tagEntity);
        }
    }

    @Override
    public int changeTagStatus(TagChangeStatusReqDTO reqDTO) {
        TagEntity tagEntity = new TagEntity();
        tagEntity.setId(reqDTO.getTagId());
        if (CategoryConst.CATEGORY_STATUS_FORBID == reqDTO.getStatus()) {
            tagEntity.setStatus(CategoryConst.CATEGORY_STATUS_FORBID);
        }
        if (CategoryConst.CATEGORY_STATUS_DEL == reqDTO.getStatus()) {
            tagEntity.setStatus(CategoryConst.CATEGORY_STATUS_DEL);
        }
        return tagMapper.updateById(tagEntity);
    }
}
