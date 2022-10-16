package com.yc.example.neo4j.dao;


import com.yc.example.neo4j.vo.RelationShip;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: youcong
 */
@Repository
public interface RelationShipRepository extends Neo4jRepository<RelationShip, Long> {
}
