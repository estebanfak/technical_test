package com.vortex.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
//@Data
@Setter
@NoArgsConstructor
@Table(name = "EMPLOYEES")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private int employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "HIRE_DATE")
    private Date hireDate;
    @ManyToOne
    @JoinColumn(name = "JOB_ID")
    private Job jobId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "employeeId")
    private Set<JobHistory> jobHistories = new HashSet<>();
    @Column(name = "SALARY")
    private double salary;
    @Column(name = "COMMISSION_PCT")
    private double commissionPct;
    @ManyToOne
    @JoinColumn(name = "MANAGER_ID")
    private Employee managerId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "managerId")
    private Set<Employee> employees = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID")
    private Department departmentId;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "managerId")
    private Set<Department> departments = new HashSet<>();

    public Employee (String firstName, String lastName, String email, String phoneNumber, double salary, double commissionPct, Job jobId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = new Date();
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.jobId = jobId;
    }
    public Employee (String firstName, String lastName, String email, String phoneNumber, double salary, double commissionPct, Job jobId, Department department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = new Date();
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.jobId = jobId;
        this.departmentId = department;
    }
    public Employee (String firstName, String lastName, String email, String phoneNumber, Date hireDate, double salary, double commissionPct, Job jobId, Department department, Employee managerId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.hireDate = hireDate;
        this.salary = salary;
        this.commissionPct = commissionPct;
        this.jobId = jobId;
        this.departmentId = department;
        this.managerId = managerId;
    }

    public void addJobHistory(JobHistory jobHistory) {
        jobHistories.add(jobHistory);
        jobHistory.setEmployeeId(this);
    }
    public void addEmployees(Employee employee) {
        employees.add(employee);
        managerId.setManagerId(this);
    }
    public void addDepartment(Department department) {
        departments.add(department);
        department.setManagerId(this);
    }

    public int getId() {
        return employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public Job getJobId() {
        return jobId;
    }

    public Set<JobHistory> getJobHistories() {
        return jobHistories;
    }

    public double getSalary() {
        return salary;
    }

    public double getCommissionPct() {
        return commissionPct;
    }

    public Employee getManagerId() {
        return managerId;
    }

    public Department getDepartmentId() {
        return departmentId;
    }
    @JsonIgnore
    public Set<Employee> getEmployees() {
        return employees;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    @JsonIgnore
    public Set<Department> getDepartments() {
        return departments;
    }
}
