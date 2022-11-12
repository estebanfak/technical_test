package com.vortex.challenge.dto;

import com.vortex.challenge.model.Department;
import com.vortex.challenge.model.Location;
import lombok.Getter;

@Getter
public class DepartmentDto {
    private short departmentId;
    private String departmentName;

    private String managerId;
    private Location locationId;

    public DepartmentDto(Department department) {
        this.departmentId = department.getDepartmentId();
        this.departmentName = department.getDepartmentName();
        if (department.getManagerId() != null) {
            this.managerId = department.getManagerId().getLastName() + ", " + department.getManagerId().getFirstName();
        }
        this.locationId = department.getLocationId();
    }

}
