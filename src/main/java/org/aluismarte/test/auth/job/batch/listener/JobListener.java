package org.aluismarte.test.auth.job.batch.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

/**
 * Created by aluis on 9/2/20.
 */
@Component
public class JobListener implements JobExecutionListener {

    private static final Logger logger = LoggerFactory.getLogger(JobListener.class);

    @Override
    public void beforeJob(JobExecution jobExecution) {
        logger.info("Job {} start on {}", jobExecution.getJobInstance().getJobName(), jobExecution.getStartTime());
    }

    @Override
    public void afterJob(JobExecution jobExecution) {
        logger.info("Job {} get status {} on {}", jobExecution.getJobInstance().getJobName(), jobExecution.getStatus(), jobExecution.getEndTime());
    }
}
