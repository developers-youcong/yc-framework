package com.yc.example.neo4j.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.annotation.Id;

/**
 * @description:
 * @author: youcong
 */
@RelationshipEntity(type = "relationShip")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RelationShip {
    @Id
    @GeneratedValue
    private Long id;

    @StartNode
    private Dept parent;

    @EndNode
    private Dept child;
}
