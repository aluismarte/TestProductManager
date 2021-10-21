package org.aluismarte.test.auth.job.schedule;

import org.aluismarte.test.auth.job.model.ScheduleJob;
import org.quartz.JobExecutionContext;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobLocator;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.stereotype.Component;

/**
 * Created by aluis on 10/21/2021.
 */
@Component
public class ProductScheduleJob extends ScheduleJob {

    public static final String NAME = "Forgot Password Task";
    public static final String DESCRIPTION = "Clear forgot password rows on DB";
    public static final String GROUP = ScheduleJob.MAINTENANCE_GROUP;

    private final JobLocator jobLocator;
    private final JobLauncher jobLauncher;

    public ProductScheduleJob(JobLocator jobLocator, JobLauncher jobLauncher) {
        this.jobLocator = jobLocator;
        this.jobLauncher = jobLauncher;
    }

    @Override
    public void execute(JobExecutionContext context) {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .toJobParameters();
            Job job = jobLocator.getJob("productJob");
            jobLauncher.run(job, jobParameters);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
