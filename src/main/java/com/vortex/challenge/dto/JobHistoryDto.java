package com.vortex.challenge.dto;

import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.JobHistory;
import lombok.Getter;

import java.util.Date;
@Getter
public class JobHistoryDto {
    private int jobHistoryId;
    private String employee;
    private Date startDate;
    private Date endDate;

    public JobHistoryDto(JobHistory jobHistory){
        this.jobHistoryId = jobHistory.getJobHistoryId();
        this.employee = jobHistory.getEmployeeId().getLastName() + ", " + jobHistory.getEmployeeId().getFirstName();
        this.startDate = jobHistory.getStartDate();
        this.endDate = jobHistory.getEndDate();
    }
}
