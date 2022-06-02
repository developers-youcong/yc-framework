package com.yc.cms.es.dao;

import com.yc.cms.es.vo.PostEsVO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @description:
 * @author: youcong
 */
public interface PostEsRepository extends ElasticsearchRepository<PostEsVO, String> {

    Page<PostEsVO> findByPostTitle(String name, Pageable pageable);
}
