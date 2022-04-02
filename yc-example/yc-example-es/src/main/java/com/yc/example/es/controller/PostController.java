package com.yc.example.es.controller;

import com.yc.example.es.dao.PostRepository;
import com.yc.example.es.vo.PostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 */
@RestController
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/add")
    public PostEntity add() {
        PostEntity entity = new PostEntity();
        entity.setID("1");
        entity.setPostAuthor("yc");
        entity.setPostTitle("it is a test");
        return postRepository.save(entity);
    }

    @GetMapping("/del")
    public void del(String ID) {
        postRepository.deleteById(ID);
    }

    @GetMapping("/list")
    public Iterable<PostEntity> list() {
        return postRepository.findAll();
    }
}
