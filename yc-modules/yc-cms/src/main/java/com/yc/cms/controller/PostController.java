package com.yc.cms.controller;

import com.yc.cms.service.PostService;
import com.yc.common.core.base.dto.cms.PostPageReqDTO;
import com.yc.common.core.base.result.RespBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description:
 * @author: youcong
 * @time: 2021/9/20 20:08
 */
@RestController
@Slf4j
@Api(tags = {"内容管理-文章管理"}, description = "内容管理-文章管理")
public class PostController {

    @Autowired
    private PostService postService;

    /**
     * 获取文章列表
     *
     * @param reqDTO
     * @return
     */
    @PostMapping("/post/queryPageList")
    @ApiOperation("获取文章列表")
    public RespBody queryPageList(@RequestBody PostPageReqDTO reqDTO) {
        log.info("/post/queryPageList:" + reqDTO);
        return RespBody.success(postService.queryPostPageList(reqDTO));
    }
}
