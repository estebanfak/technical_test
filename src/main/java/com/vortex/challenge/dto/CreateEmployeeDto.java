package com.vortex.challenge.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.Date;
@Getter
@NoArgsConstructor
public class CreateEmployeeDto {
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    private String phoneNumber;
    private double salary;
    private double commissionPct;
    @NotBlank
    private String jobId;
}
