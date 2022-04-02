package com.yc.example.es.dao;

import com.yc.example.es.vo.PostEntity;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: youcong
 */
@Repository
public interface PostRepository extends ElasticsearchRepository<PostEntity, String> {
}
