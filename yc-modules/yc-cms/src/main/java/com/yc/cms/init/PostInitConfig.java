package com.yc.cms.init;

import cn.hutool.core.thread.ThreadUtil;
import com.yc.cms.es.dao.PostEsRepository;
import com.yc.cms.es.vo.PostEsVO;
import com.yc.cms.mapper.PostMapper;
import com.yc.common.core.base.entity.cms.PostEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@Component
@Slf4j
public class PostInitConfig {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private PostEsRepository postEsRepository;

    @PostConstruct
    public void initPost() {
        ThreadUtil.execAsync(() -> {
            List<PostEntity> dataList = postMapper.selectList(null);
            List<PostEsVO> postEsList = new ArrayList<>();
            if (!dataList.isEmpty()) {
                PostEsVO esVO = null;
                for (PostEntity post : dataList) {
                    esVO = new PostEsVO();
                    esVO.setId(post.getId());
                    esVO.setPostTitle(post.getPostTitle());
                    esVO.setPostAuthor(post.getPostAuthor());
                    esVO.setPostContent(post.getPostContent());
                    esVO.setOriginUrl(post.getOriginUrl());
                    esVO.setPostExcerpt(post.getPostExcerpt());
                    esVO.setCreateTime(post.getCreateTime());
                    esVO.setUpdateTime(post.getUpdateTime());
                    esVO.setCompanyId(post.getCompanyId());
                    esVO.setCommentStatus(post.getCommentStatus());
                    esVO.setBackgroupImg(post.getBackgroupImg());
                    esVO.setPostStatus(post.getPostStatus());
                    esVO.setCategoryId(post.getCategoryId());
                    esVO.setTagId(post.getTagId());
                    postEsList.add(esVO);
                }
            }
            postEsRepository.deleteAll();
            postEsRepository.saveAll(postEsList);
            log.info("初始化文章加载ES");
        });

    }
}
