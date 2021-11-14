package com.yc.job.config;

import com.yc.job.task.CnBlogsJobTask;
import com.yc.job.task.ZqCityHourJobTask;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: youcong
 * @time: 2021/11/4 20:05
 */
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail zqJobDetail() {
        return JobBuilder.newJob(ZqCityHourJobTask.class).withIdentity("zqCityHourJobTask").storeDurably().build();
    }

    @Bean
    public JobDetail cnBlogsJobDetail() {
        return JobBuilder.newJob(CnBlogsJobTask.class).withIdentity("cnBlogsJobTask").storeDurably().build();
    }

    @Bean
    public Trigger zqCronJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("04 08 * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(zqJobDetail())
                .withIdentity("zqCronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    @Bean
    public Trigger cnblogsCronJobTrigger() {
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule("04 20 * * * ?");

        return TriggerBuilder.newTrigger()
                .forJob(cnBlogsJobDetail())
                .withIdentity("cnblogsCronJobTrigger")
                .withSchedule(cronScheduleBuilder)
                .build();
    }
}
