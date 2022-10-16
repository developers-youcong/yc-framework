package com.yc.example.neo4j.controller;

import com.yc.example.neo4j.dao.DeptRepository;
import com.yc.example.neo4j.dao.RelationShipRepository;
import com.yc.example.neo4j.vo.Dept;
import com.yc.example.neo4j.vo.RelationShip;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class TestController {
    @Resource
    private DeptRepository deptRepository;
    @Resource
    private RelationShipRepository relationShipRepository;

    @GetMapping("create")
    public void create() {
        Dept root = new Dept(1L, "软件部");
        Dept dept1 = new Dept(2L, "架构组");
        Dept dept2 = new Dept(3L, "开发组");
        Dept dept3 = new Dept(4L, "实施组");

        List<Dept> deptList = new ArrayList<>(Arrays.asList(root, dept1, dept2, dept3));
        deptRepository.saveAll(deptList);

        RelationShip relationShip1 = new RelationShip(1L, root, dept1);
        RelationShip relationShip2 = new RelationShip(2L, root, dept2);
        RelationShip relationShip3 = new RelationShip(3L, root, dept3);

        List<RelationShip> relationShipList = new ArrayList<>(Arrays.asList(relationShip1, relationShip2, relationShip3));
        relationShipRepository.saveAll(relationShipList);
    }


    @GetMapping("/list")
    public List<Dept> list() {
        return (List<Dept>) deptRepository.findAll();
    }


    @GetMapping("deleteRelationShip")
    public void deleteRelationShip(Long id) {
        relationShipRepository.deleteById(id);
    }

    @GetMapping("deleteDept")
    public void deleteDept(Long id) {
        deptRepository.deleteById(id);
    }

    @GetMapping("deleteAll")
    public void deleteAll() {
        deptRepository.deleteAll();
        relationShipRepository.deleteAll();
    }

}
