package com.vortex.challenge.dto;

import com.vortex.challenge.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class EmployeeDto {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private JobDto jobDto;
    private Set<JobHistoryDto> jobHistories = new HashSet<>();
    private Double salary;
    private Double commissionPct;
    private ManagerDto managerId;
    private Set<EmployeeToShowDto> employeeDtos = new HashSet<>();
    private DepartmentDto departmentId;
    private Set<DepartmentDto> departments = new HashSet<>();

    public EmployeeDto(Employee employee) {
        this.employeeId = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();
        this.hireDate = employee.getHireDate();
        this.jobDto = new JobDto(employee.getJobId());
        this.salary = employee.getSalary();
        this.commissionPct = employee.getCommissionPct();
        if (employee.getManagerId() != null) {
            this.managerId = new ManagerDto(employee.getManagerId());
        }
        if(employee.getDepartmentId()!=null){
        this.departmentId = new DepartmentDto(employee.getDepartmentId());
        }
        this.jobHistories = employee.getJobHistories().stream().map(JobHistoryDto::new).collect(Collectors.toSet());
        if(employee.getManagerId()==null){
            this.employeeDtos = employee.getEmployees().stream().map(EmployeeToShowDto::new).collect(Collectors.toSet());
        }
        this.departments = employee.getDepartments().stream().map(DepartmentDto::new).collect(Collectors.toSet());

    }
}
