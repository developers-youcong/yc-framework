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
 * @time: 2021/11/4 20:33
 */
@Slf4j
public class ZqCityHourJobTask extends QuartzJobBean {
    @Autowired
    private CrawlerApi crawlerApi;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("执行真气网小时数据抓取定时任务");
        crawlerApi.zq_city_hour();
    }
}
