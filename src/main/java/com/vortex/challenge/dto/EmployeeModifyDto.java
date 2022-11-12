package com.vortex.challenge.dto;

import lombok.Getter;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Getter
public class EmployeeModifyDto {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Date hireDate;
    private String jobId;
    private Double salary;
    private Double commissionPct;
    private int managerId;
}
