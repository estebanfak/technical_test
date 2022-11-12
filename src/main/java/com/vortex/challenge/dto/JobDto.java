package com.vortex.challenge.dto;

import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Job;
import com.vortex.challenge.model.JobHistory;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;
@Getter
public class JobDto {
    private String jobId;
    private String jobTitle;
    private short minSalary;
    private short maxSalary;
//    private Set<Employee> employees = new HashSet<>();
//    private Set<JobHistory> jobHistories = new HashSet<>();

    public JobDto(Job job){
        this.jobId = job.getJobId();
        this.jobTitle = job.getJobTitle();
        this.minSalary = job.getMinSalary();
        this.maxSalary = job.getMaxSalary();
//        this.employees = job.getEmployees();
//        this.jobHistories = job.getJobHistories();
    }
}
