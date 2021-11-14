package com.yc.api;

import com.yc.common.core.base.constant.ApplicationConst;
import com.yc.common.core.base.result.ResultBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/4 20:19
 */
@FeignClient(contextId = "crawlerApi", name = ApplicationConst.CRAWLER)
public interface CrawlerApi {

    /**
     * 真气网-城市小时级数据抓取
     *
     * @return
     */
    @PostMapping("/dataCrawler/zq_city_hour")
    ResultBody zq_city_hour();

    /**
     * 基于博客园用户相关的文章抓取
     *
     * @return
     */
    @PostMapping("/dataCrawler/cnblog_user")
    ResultBody cnblog_user();

    /**
     * 博客园首页文章抓取
     *
     * @return
     */
    @PostMapping("/dataCrawler/cnblogs_home")
    ResultBody cnblogs_home();

    /**
     * 博客园精品文章抓取
     *
     * @return
     */
    @PostMapping("/dataCrawler/cnblog_es")
    ResultBody cnblog_es();
}
