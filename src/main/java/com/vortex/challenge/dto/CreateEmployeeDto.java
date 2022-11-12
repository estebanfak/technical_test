package com.vortex.challenge.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
@Getter
@NoArgsConstructor
public class CreateEmployeeDto {
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String email;
    private String phoneNumber;
    @NotNull
    private Date hireDate;
    private double salary;
    private double commissionPct;
    private String jobId;
    private short departmentId;
}
