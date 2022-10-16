package com.yc.example.neo4j.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;
import org.springframework.data.annotation.Id;

/**
 * @description:
 * @author: youcong
 */
@NodeEntity(label = "dept")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Dept {

    @Id
    @GeneratedValue
    private Long id;

    @Property(name = "deptName")
    private String deptName;


}
