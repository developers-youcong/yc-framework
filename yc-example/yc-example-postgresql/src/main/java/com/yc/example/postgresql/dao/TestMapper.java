package com.yc.example.postgresql.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yc.example.postgresql.entity.TestEntity;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: youcong
 */
@Repository
public interface TestMapper extends BaseMapper<TestEntity> {
}
