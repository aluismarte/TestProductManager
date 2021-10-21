package org.aluismarte.test.auth.job;

import org.aluismarte.test.auth.job.model.AbstractScheduleManager;
import org.aluismarte.test.auth.job.schedule.ProductScheduleJob;
import org.aluismarte.test.auth.job.schedule.TestScheduleJob;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

/**
 * Created by aluis on 8/15/20.
 */
@Configuration
public class ScheduleManager extends AbstractScheduleManager {

    private static final Logger logger = LoggerFactory.getLogger(ScheduleManager.class);

    @Bean
    public SimpleTriggerFactoryBean testTrigger() {
        String name = TestScheduleJob.NAME + TEST;
        String description = TestScheduleJob.DESCRIPTION + TEST;
        String group = TestScheduleJob.GROUP + TEST;
        JobDetail jobDetail = createJobDetail(TestScheduleJob.class, name, description);
        return createSimpleTrigger(jobDetail, name, description, group, 2, 3, 0);
    }

    @Bean
    public SimpleTriggerFactoryBean productTestTrigger() {
        String name = ProductScheduleJob.NAME + TEST;
        String description = ProductScheduleJob.DESCRIPTION + TEST;
        String group = ProductScheduleJob.GROUP + TEST;
        JobDetail jobDetail = createJobDetail(ProductScheduleJob.class, name, description);
        return createSimpleTrigger(jobDetail, name, description, group, 12, 2, 20);
    }
}
