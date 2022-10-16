package com.yc.example.neo4j.dao;

import com.yc.example.neo4j.vo.Dept;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: youcong
 * @time: 2022/9/23 11:35
 */
@Repository
public interface DeptRepository extends Neo4jRepository<Dept, Long> {
}
