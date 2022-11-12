package com.vortex.challenge.dto;

import com.vortex.challenge.model.Department;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Job;
import com.vortex.challenge.model.JobHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class EmployeeDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private Job jobId;
    private Double salary;
    private Double commissionPct;
    private ManagerDto managerId;
    private Department departmentId;
    private Set<JobHistory> jobHistories = new HashSet<>();
    private Set<EmployeeToShowDto> employeeDtos = new HashSet<>();

    public EmployeeDto(Employee employee) {
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.hireDate = employee.getHireDate();
        this.jobId = employee.getJobId();
        this.salary = employee.getSalary();
        this.commissionPct = employee.getCommissionPct();
        if (employee.getManagerId() != null) {
            this.managerId = new ManagerDto(employee.getManagerId());
        }
        this.departmentId = employee.getDepartmentId();
        this.jobHistories = employee.getJobHistories();
        if(employee.getManagerId()==null){
            this.employeeDtos = employee.getEmployees().stream().map(EmployeeToShowDto::new).collect(Collectors.toSet());
        }

    }
}
