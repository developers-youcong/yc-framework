package com.yc.example.shedlock.task;

import lombok.extern.slf4j.Slf4j;
import net.javacrumbs.shedlock.spring.annotation.SchedulerLock;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: youcong
 */
@Slf4j
@Component
public class JobTest {
    @Scheduled(cron = "1 * * * * ?")
    @SchedulerLock(name = "testJob")
    public void testJob() {
        log.info("testJob");
    }

}
