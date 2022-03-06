package com.yc.api;

import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.result.RespBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: youcong
 * @time: 2021/10/4 9:28
 */
@FeignClient(contextId = "cnBlogsApi",name = ApplicationConst.PLUGINS)
public interface CnBlogsApi {
    @PostMapping("/cnblogs/getToken")
    RespBody getToken();

    @PostMapping("/cnblogs/getPersonalBlogInfo")
    RespBody getPersonalBlogInfo(@RequestParam("username") String username);

    @PostMapping("/cnblogs/getPersonalBlogPostList")
    RespBody getPersonalBlogPostList(@RequestParam("userName") String userName, @RequestParam("pageIndex") Integer pageIndex);

    @PostMapping("/cnblogs/getEssenceAreaPostList")
    RespBody getEssenceAreaPostList(@RequestParam("pageIndex") String pageIndex, @RequestParam("pageSize") String pageSize);

    @PostMapping("/cnblogs/getSiteHomePostList")
    RespBody getSiteHomePostList(@RequestParam("pageIndex") String pageIndex, @RequestParam("pageSize") String pageSize);
}
