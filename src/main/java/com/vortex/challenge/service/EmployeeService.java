package com.vortex.challenge.service;

import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.dto.EmployeeModifyDto;
import com.vortex.challenge.exception.DepartmentNotFoundException;
import com.vortex.challenge.exception.EmployeeNotFoundException;
import com.vortex.challenge.exception.JobNotFoundException;
import com.vortex.challenge.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {

    Page<EmployeeDto> getAll(int offset, int pageSize);
    EmployeeDto newEmployee(CreateEmployeeDto createEmployeeDto) throws JobNotFoundException, DepartmentNotFoundException;
    EmployeeDto modifyEmployee(int employeeId, EmployeeModifyDto employeeModifyDto) throws EmployeeNotFoundException, JobNotFoundException;
    EmployeeDto deleteEmployee(int employeeId) throws EmployeeNotFoundException;
    EmployeeDto getEmployeeById(int id) throws EmployeeNotFoundException;
    Page<EmployeeDto> filterByJobIdId(String jobId, int offset, int pageSize);
    Page<EmployeeDto> filterByManagerId(int managerId, int offset, int pageSize);
    Page<EmployeeDto> filterByLastName(String lastName, int offset, int pageSize);
    Page<EmployeeDto> employeesSortedByHireDateAscending(int offset, int pageSize);
    List<Employee> getAllEmployeesList();
}
