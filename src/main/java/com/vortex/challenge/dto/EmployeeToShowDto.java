package com.vortex.challenge.dto;

import com.vortex.challenge.model.Department;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Job;
import com.vortex.challenge.model.JobHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class EmployeeToShowDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Job jobId;
    private double salary;
    private double commissionPct;
    private Department departmentId;
    private Set<JobHistory> jobHistories = new HashSet<>();

    public EmployeeToShowDto(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.hireDate = employee.getHireDate();
        this.jobId = employee.getJobId();
        this.salary = employee.getSalary();
        this.commissionPct = employee.getCommissionPct();
        this.departmentId = employee.getDepartmentId();
        this.jobHistories = employee.getJobHistories();
    }

}
