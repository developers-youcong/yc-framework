package com.yc.example.quartz;


import org.quartz.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @description:
 * @author: youcong
 */
@Configuration
public class QuartzConfig {
    /**
     * 定义任务
     */
    @Bean
    public JobDetail testJob() {
        JobDataMap data = new JobDataMap(); //通过JobDataMap向任务中传递参数
        return JobBuilder.newJob(TestJob.class).withIdentity("TestJob").usingJobData(data).storeDurably()
                .build();
    }

    /**
     * 定义触发器
     */
    @Bean
    public Trigger syncPwdTrigger(@Qualifier("testJob") JobDetail job) {
        ScheduleBuilder<?> csb = getScheduleBuilderWithMillisecond(10000); // 每10秒运行一次

        return TriggerBuilder.newTrigger().forJob(job).withIdentity("TestTrigger").withSchedule(csb).build();
    }

    private ScheduleBuilder<?> getScheduleBuilderWithMillisecond(long milliSecond) {
        SimpleScheduleBuilder ssb = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(milliSecond).repeatForever();
        return ssb.repeatForever();
    }

}
