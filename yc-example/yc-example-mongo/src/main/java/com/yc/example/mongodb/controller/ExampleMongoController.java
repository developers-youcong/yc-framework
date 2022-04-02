package com.yc.example.mongodb.controller;

import com.yc.common.mongodb.MongoService;
import com.yc.example.mongodb.vo.ExampleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class ExampleMongoController {

    @Autowired
    private MongoService mongoService;

    @GetMapping("/add")
    public String add() {
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName("add");
        exampleEntity.setEmail("add@163.com");
        mongoService.saveData("xx", exampleEntity);
        return "save ok";
    }

    @GetMapping("/del")
    public String del(@RequestParam String collName) {
        mongoService.removeIndexByName(collName);
        return "del ok";
    }

    @GetMapping("/modify")
    public String modify() {
        ExampleEntity exampleEntity = new ExampleEntity();
        exampleEntity.setName("oop");
        exampleEntity.setEmail("oop@163.com");
        Map<String, Object> con = new HashMap<>();
        con.put("name", "add");

        mongoService.updateMulti("6246cb3c8c7ab541e03514c5", exampleEntity, con, "xx", 0);
        return "modify ok";
    }

    @GetMapping("/list")
    public Object list(@RequestParam String collName) {
        return mongoService.findAll(ExampleEntity.class, collName);
    }
}
