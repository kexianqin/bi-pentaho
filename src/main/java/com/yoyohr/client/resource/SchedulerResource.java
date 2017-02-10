package com.yoyohr.client.resource;

import com.yoyohr.client.Response;

/**
 * Summary
 *
 * @author Leo <jiangwenhua@yoyohr.com>
 */
public class SchedulerResource extends Resource {

    public static final String SCHEDULER = "/api/scheduler/";

    public static final String SCHEDULER_GET_JOBS = SCHEDULER + "getJobs";

    public SchedulerResource(Response response) {
        super(response);
    }

    public String getJobs() {
        return response.toString();
    }
}
