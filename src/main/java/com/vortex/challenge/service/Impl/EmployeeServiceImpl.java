package com.vortex.challenge.service.Impl;

import com.vortex.challenge.constant.Messages;
import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.dto.EmployeeModifyDto;
import com.vortex.challenge.exception.DepartmentNotFoundException;
import com.vortex.challenge.exception.EmployeeNotFoundException;
import com.vortex.challenge.exception.JobNotFoundException;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Job;
import com.vortex.challenge.repository.EmployeeRepository;
import com.vortex.challenge.service.DepartmentService;
import com.vortex.challenge.service.EmployeeService;
import com.vortex.challenge.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JobService jobService;

    @Override
    public EmployeeDto newEmployee(CreateEmployeeDto createEmployeeDto) throws JobNotFoundException {
        Employee employee = new Employee(createEmployeeDto.getFirstName(),
                createEmployeeDto.getLastName(),
                createEmployeeDto.getEmail(),
                createEmployeeDto.getPhoneNumber(),
                createEmployeeDto.getSalary(),
                createEmployeeDto.getCommissionPct(),
                jobService.findByJobId(createEmployeeDto.getJobId()));
        return new EmployeeDto(employeeRepository.save(employee));
    }
    @Override
    public EmployeeDto modifyEmployee(int employeeId, EmployeeModifyDto employeeModifyDto) throws EmployeeNotFoundException, JobNotFoundException {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(() -> new EmployeeNotFoundException(Messages.EMPLOYEE_NOT_FOUND));;
        return new EmployeeDto(employeeRepository.save(modifyFields(employee, employeeModifyDto)));
    }
    @Override
    public EmployeeDto deleteEmployee(int employeeId) throws EmployeeNotFoundException {
        Employee employee = employeeRepository.findByEmployeeId(employeeId).orElseThrow(() -> new EmployeeNotFoundException(Messages.EMPLOYEE_NOT_FOUND));
        EmployeeDto employeeDto = new EmployeeDto(employee);
        employeeRepository.delete(employee);
        return employeeDto;
    }
    @Override
    public EmployeeDto getEmployeeById(int id) throws EmployeeNotFoundException {
        return new EmployeeDto(employeeRepository.findByEmployeeId(id).orElseThrow(() ->  new EmployeeNotFoundException(Messages.EMPLOYEE_NOT_FOUND)));
    }
    @Override
    public Page<EmployeeDto> getAll(int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findAll(PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).collect(Collectors.toList()));
    }
    @Override
    public Page<EmployeeDto> filterByJobIdId(String jobId, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByJobIdJobId(jobId, PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> filterByManagerId(int managerId, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByManagerId(employeeRepository.findByEmployeeId(managerId).orElse(null), PageRequest.of(offset, pageSize)).map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> filterByLastName(String lastName, int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findByLastName(lastName, PageRequest.of(offset, pageSize)).stream().map(EmployeeDto::new).toList());
    }
    @Override
    public Page<EmployeeDto> employeesSortedByHireDateAscending(int offset, int pageSize) {
        return new PageImpl<>(employeeRepository.findAll(PageRequest.of(offset, pageSize).withSort(Sort.Direction.ASC, "hireDate")).stream().map(EmployeeDto::new).collect(Collectors.toList()));
    }
    @Override
    public List<Employee> getAllEmployeesList() {
        return employeeRepository.findAll();
    }
    private Employee modifyFields(Employee employee, EmployeeModifyDto employeeModifyDto) throws JobNotFoundException, EmployeeNotFoundException {
        employee.setFirstName(employeeModifyDto.getFirstName());
        employee.setLastName(employeeModifyDto.getLastName());
        employee.setEmail(employeeModifyDto.getEmail());
        employee.setPhoneNumber(employeeModifyDto.getPhoneNumber());
        employee.setJobId(jobService.findByJobId(employeeModifyDto.getJobId()));
        employee.setSalary(employeeModifyDto.getSalary());
        employee.setCommissionPct(employeeModifyDto.getCommissionPct());
        employee.setManagerId(employeeRepository.findByEmployeeId(employeeModifyDto.getManagerId()).orElseThrow(()-> new EmployeeNotFoundException(Messages.MANAGER_NOT_FOUND)));
        return employee;
    }
}
