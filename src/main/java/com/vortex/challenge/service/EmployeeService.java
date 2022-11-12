package com.vortex.challenge.service;

import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.model.Employee;
import org.springframework.data.domain.Page;

import java.util.List;


public interface EmployeeService {

    Page<EmployeeDto> getAll(int offset, int pageSize);
    EmployeeDto newEmployee(CreateEmployeeDto createEmployeeDto);
    EmployeeDto modifyEmployee(EmployeeDto employeeDto) throws Exception;
    EmployeeDto deleteEmployee(int employeeId) throws Exception;
    EmployeeDto getEmployeeById(int id) throws Exception;
    Page<EmployeeDto> filterByJobIdId(int jobId, int offset, int pageSize);
    Page<EmployeeDto> filterByManagerId(int managerId, int offset, int pageSize);
    Page<EmployeeDto> filterByLastName(String lastName, int offset, int pageSize);
    Page<EmployeeDto> employeesSortedByHireDateAscending(int offset, int pageSize);
    List<Employee> getAllEmployeesList();
    void setManager(int manager, int employee);


}
