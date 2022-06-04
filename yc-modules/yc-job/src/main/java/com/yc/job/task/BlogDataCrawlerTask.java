package com.yc.job.task;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.XxlJob;
import com.yc.api.CnBlogsApi;
import com.yc.api.CrawlerApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Component
@Slf4j
public class BlogDataCrawlerTask {

    @Autowired
    private CrawlerApi crawlerApi;

    @XxlJob("cnblogs_home")
    public void cnblogs_home(){
        crawlerApi.cnblogs_home();
        XxlJobHelper.log("首页数据抓取");
    }


    @XxlJob("cnblog_es")
    public void cnblog_es(){
        crawlerApi.cnblog_es();
        XxlJobHelper.log("精华数据抓取");
    }


    @XxlJob("cnblog_user")
    public void cnblog_user(){
        crawlerApi.cnblog_user();
        XxlJobHelper.log("用户文章数据抓取");
    }
}
