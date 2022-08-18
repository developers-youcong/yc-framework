# 定时任务

## 一、编写规则
建议在yc-job模块下编写。至于需要执行的任务，可通过API形式放入yc-job中。

## 二、代码示例
源代码位于:
https://github.com/developers-youcong/yc-framework/tree/main/yc-modules/yc-job


### 1.编写定时任务
```
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

```

### 2.代码配置
```
@Configuration
public class QuartzConfiguration {

    @Bean
    public JobDetail cnBlogsJobDetail() {
        return JobBuilder.newJob(CnBlogsJobTask.class).withIdentity("cnBlogsJobTask").storeDurably().build();
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


```

