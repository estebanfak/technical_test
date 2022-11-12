package com.vortex.challenge.repository;

import com.vortex.challenge.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    Job findByJobId(String jobId);
}
