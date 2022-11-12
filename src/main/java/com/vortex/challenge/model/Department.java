package com.vortex.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Setter
@NoArgsConstructor
@Table(name = "DEPARTMENTS")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DEPARTMENT_ID")
    private short departmentId;
    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee managerId;

    @ManyToOne
    @JoinColumn(name = "LOCATION_ID")
    private Location locationId;
    @OneToMany(mappedBy = "departmentId")
    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "departmentId")
    private Set<JobHistory> jobHistories = new HashSet<>();

    public Department(String departmentName, Location locationId){
        this.departmentName = departmentName;
        this.locationId = locationId;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
        employee.setDepartmentId(this);
    }
    public void addJobHistory(JobHistory jobHistory) {
        jobHistories.add(jobHistory);
        jobHistory.setDepartmentId(this);
    }

    public short getDepartmentId() {
        return departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public Location getLocationId() {
        return locationId;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    @JsonIgnore
    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }
}
