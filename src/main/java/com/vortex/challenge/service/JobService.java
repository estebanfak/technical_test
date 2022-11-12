package com.vortex.challenge.service;

import com.vortex.challenge.exception.JobNotFoundException;
import com.vortex.challenge.model.Job;

public interface JobService {
    Job findByJobId(String jobId) throws JobNotFoundException;
}
