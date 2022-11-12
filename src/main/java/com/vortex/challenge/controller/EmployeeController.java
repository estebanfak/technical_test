package com.vortex.challenge.controller;

import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.dto.EmployeeModifyDto;
import com.vortex.challenge.exception.DepartmentNotFoundException;
import com.vortex.challenge.exception.EmployeeNotFoundException;
import com.vortex.challenge.exception.JobNotFoundException;
import com.vortex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/{offset}/{pageSize}")
    public ResponseEntity<?> getAll(@PathVariable int offset,
                                 @PathVariable int pageSize){
        return ResponseEntity.ok(employeeService.getAll(offset, pageSize));
    }
    @PostMapping
    public ResponseEntity<?> newEmployee(@RequestBody CreateEmployeeDto createEmployeeDto) throws JobNotFoundException, DepartmentNotFoundException {
        return ResponseEntity.ok(employeeService.newEmployee(createEmployeeDto));
    }
    @PatchMapping("/{employeeId}")
    public ResponseEntity<?> modifyEmployee(@PathVariable int employeeId,
                                            @RequestBody EmployeeModifyDto employeeModifyDto) throws EmployeeNotFoundException, JobNotFoundException {
        return ResponseEntity.ok(employeeService.modifyEmployee(employeeId, employeeModifyDto));
    }
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable int employeeId) throws EmployeeNotFoundException{
        return ResponseEntity.ok(employeeService.deleteEmployee(employeeId));
    }
    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getEmployeeById(@PathVariable int employeeId) throws EmployeeNotFoundException {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }
    @GetMapping("/jobId/{jobId}/{offset}/{pageSize}")
    public ResponseEntity<?> filterByJobId(@PathVariable String jobId,
                                           @PathVariable int offset,
                                           @PathVariable int pageSize){
        return ResponseEntity.ok(employeeService.filterByJobIdId(jobId, offset, pageSize));
    }
    @GetMapping("/managerId/{managerId}/{offset}/{pageSize}")
    public ResponseEntity<?> filterByManagerId(@PathVariable int managerId,
                                               @PathVariable int offset,
                                               @PathVariable int pageSize){
        return ResponseEntity.ok(employeeService.filterByManagerId(managerId, offset, pageSize));
    }
    @GetMapping("/lastName/{lastName}/{offset}/{pageSize}")
    public ResponseEntity<?> filterByLastName(@PathVariable String lastName,
                                              @PathVariable int offset,
                                              @PathVariable int pageSize){
        return ResponseEntity.ok(employeeService.filterByLastName(lastName, offset, pageSize));
    }
    @GetMapping("/sorted/{offset}/{pageSize}")
    public ResponseEntity<?> employeesSortedByHireDateAscending(@PathVariable int offset,
                                                                @PathVariable int pageSize){
        return ResponseEntity.ok(employeeService.employeesSortedByHireDateAscending(offset, pageSize));

    }
}
