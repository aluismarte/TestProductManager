package org.aluismarte.test.auth.job.model;

import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.SimpleTriggerFactoryBean;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by aluis on 8/23/20.
 */
public abstract class AbstractScheduleManager {

    private static final String TRIGGERS = "Trigger_";
    protected static final String TEST = "_Test";

    /**
     * Prepare a CronTrigger for a job
     *
     * @param jobDetail      Job to run
     * @param name           Name of job
     * @param description    Description of job
     * @param group          Group of job
     * @param startTime      To fix problem: clear seconds and millis to remove bug on time
     * @param cronExpression Expression to run
     * @return CronTriggerFactoryBean
     */
    protected CronTriggerFactoryBean createCronTrigger(JobDetail jobDetail, String name, String description, String group, Date startTime, String cronExpression) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(startTime);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetail);
        cronTriggerFactoryBean.setCronExpression(cronExpression);
        cronTriggerFactoryBean.setStartTime(calendar.getTime());
        cronTriggerFactoryBean.setStartDelay(0L);
        cronTriggerFactoryBean.setName(String.format("%s%s", TRIGGERS, name));
        cronTriggerFactoryBean.setDescription(description);
        cronTriggerFactoryBean.setGroup(group);
        cronTriggerFactoryBean.setMisfireInstruction(CronTrigger.MISFIRE_INSTRUCTION_DO_NOTHING);
        return cronTriggerFactoryBean;
    }

    /**
     * Prepare a Simple RRepeatable job
     *
     * @param jobDetail             Job to run
     * @param name                  Name of job
     * @param description           Description of job
     * @param group                 Group of job
     * @param repeatIntervalSeconds Seconds to wait to execute again
     * @param repeatCount           Quantity of repeat (always is repeatCount + 1)
     * @return SimpleTriggerFactoryBean
     */
    protected SimpleTriggerFactoryBean createSimpleTrigger(JobDetail jobDetail, String name, String description, String group, int repeatIntervalSeconds, int repeatCount, int startDelaySeconds) {
        SimpleTriggerFactoryBean simpleTriggerFactoryBean = new SimpleTriggerFactoryBean();
        simpleTriggerFactoryBean.setJobDetail(jobDetail);
        simpleTriggerFactoryBean.setRepeatInterval(TimeUnit.SECONDS.toMillis(repeatIntervalSeconds));
        simpleTriggerFactoryBean.setRepeatCount(repeatCount);
        simpleTriggerFactoryBean.setStartDelay(TimeUnit.SECONDS.toMillis(startDelaySeconds));
        simpleTriggerFactoryBean.setName(String.format("%s%s", TRIGGERS, name));
        simpleTriggerFactoryBean.setDescription(description);
        simpleTriggerFactoryBean.setGroup(group);
        return simpleTriggerFactoryBean;
    }

    public <T extends Job> JobDetail createJobDetail(Class<T> tClass, String name, String description) {
        return JobBuilder.newJob().ofType(tClass)
                .storeDurably()
                .withIdentity(name)
                .withDescription(description)
                .build();
    }
}
