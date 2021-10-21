package org.aluismarte.test.auth.job.schedule;

import org.aluismarte.test.auth.job.model.ScheduleJob;
import org.owasp.encoder.Encode;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by aluis on 8/15/20.
 */
@Component
public class TestScheduleJob extends ScheduleJob {

    private static final Logger logger = LoggerFactory.getLogger(TestScheduleJob.class);

    public static final String NAME = "Test Task";
    public static final String DESCRIPTION = "Validate custom Spring and Quartz configuration";
    public static final String GROUP = ScheduleJob.TEST_GROUP;

    @Override
    public void execute(JobExecutionContext context) {
        logger.info("Running {} on {}", Encode.forJava(describe()), LocalDateTime.now());
    }

    public static String describe() {
        return String.format("%s :: %s", NAME, DESCRIPTION);
    }
}
