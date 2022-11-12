package com.vortex.challenge.dto;

import com.vortex.challenge.model.Employee;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ManagerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


    public ManagerDto(Employee employee){
        this.id = employee.getId();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.email = employee.getEmail();
        this.phoneNumber = employee.getPhoneNumber();

    }
}
