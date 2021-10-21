package org.aluismarte.test.auth.job.model;

import org.quartz.Job;

/**
 * http://www.quartz-scheduler.org/documentation/quartz-2.2.x/examples/Example3.html
 * <p>
 * Created by aluis on 10/21/2021.
 */
public abstract class ScheduleJob implements Job {

    protected static final String TEST_GROUP = "Test Group";
    protected static final String MAINTENANCE_GROUP = "Maintenance Group";

}
