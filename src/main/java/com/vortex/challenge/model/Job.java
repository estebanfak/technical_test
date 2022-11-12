package com.vortex.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "JOBS")
public class Job {

    @Id
    @Column(name = "JOB_ID")
    private String jobId;
    @Column(name = "JOB_TITLE")
    private String jobTitle;
    @Column(name = "MIN_SALARY")
    private short minSalary;
    @Column(name = "MAX_SALARY")
    private short maxSalary;
    @OneToMany(mappedBy = "jobId")
    private Set<Employee> employees = new HashSet<>();
    @OneToMany(mappedBy = "jobId")
    private Set<JobHistory> jobHistories = new HashSet<>();


    public Job(String jobId, String jobTitle, short minSalary, short maxSalary){
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.minSalary = minSalary;
        this.maxSalary = maxSalary;

    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setJobId(this);
    }
    public void addJobHistory(JobHistory jobHistory) {
        jobHistories.add(jobHistory);
        jobHistory.setJobId(this);
    }
}
