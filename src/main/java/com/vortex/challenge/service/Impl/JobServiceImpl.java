package com.vortex.challenge.service.Impl;

import com.vortex.challenge.constant.Messages;
import com.vortex.challenge.exception.JobNotFoundException;
import com.vortex.challenge.model.Job;
import com.vortex.challenge.repository.JobRepository;
import com.vortex.challenge.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job findByJobId(String jobId) throws JobNotFoundException {
        return jobRepository.findByJobId(jobId).orElseThrow(()-> new JobNotFoundException(Messages.JOB_NOT_FOUND));
    }
}
