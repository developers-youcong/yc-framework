package com.yc.job.task;

import com.yc.api.CrawlerApi;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/5 20:10
 */
@Slf4j
public class CnBlogsJobTask extends QuartzJobBean {

    @Autowired
    private CrawlerApi crawlerApi;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("抓取博客园数据");
        crawlerApi.cnblog_es();
        crawlerApi.cnblogs_home();
        crawlerApi.cnblog_user();
    }
}
