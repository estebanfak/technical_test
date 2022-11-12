package com.vortex.challenge.controller;

import com.vortex.challenge.dto.CreateEmployeeDto;
import com.vortex.challenge.dto.EmployeeDto;
import com.vortex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/{offset}/{pageSize}")
    public Page<EmployeeDto> getAll(@PathVariable int offset,
                                    @PathVariable int pageSize){
        return employeeService.getAll(offset, pageSize);
    }
    @PostMapping
    public EmployeeDto newEmployee(@RequestBody CreateEmployeeDto createEmployeeDto){
        return employeeService.newEmployee(createEmployeeDto);
    }
    @PatchMapping
    public EmployeeDto modifyEmployee(@RequestBody EmployeeDto employeeDto) throws Exception {
        return employeeService.modifyEmployee(employeeDto);
    }
    @DeleteMapping("/{employeeId}")
    public EmployeeDto deleteEmployee(@PathVariable int employeeId) throws Exception{
        return employeeService.deleteEmployee(employeeId);
    }
    @GetMapping("/{employeeId}")
    public EmployeeDto getEmployeeById(@PathVariable int employeeId) throws Exception {
        return employeeService.getEmployeeById(employeeId);
    }
    @GetMapping("/jobId/{jobId}/{offset}/{pageSize}")
    public Page<EmployeeDto> filterByJobId(@PathVariable int jobId,
                                           @PathVariable int offset,
                                           @PathVariable int pageSize){
        return employeeService.filterByJobIdId(jobId, offset, pageSize);
    }
    @GetMapping("/managerId/{managerId}/{offset}/{pageSize}")
    public Page<EmployeeDto> filterByManagerId(@PathVariable int managerId,
                                               @PathVariable int offset,
                                               @PathVariable int pageSize){
        return employeeService.filterByManagerId(managerId, offset, pageSize);
    }
    @GetMapping("/lastName/{lastName}/{offset}/{pageSize}")
    public Page<EmployeeDto> filterByLastName(@PathVariable String lastName,
                                              @PathVariable int offset,
                                              @PathVariable int pageSize){
        return employeeService.filterByLastName(lastName, offset, pageSize);
    }
    @GetMapping("/sorted/{offset}/{pageSize}")
    public Page<EmployeeDto> employeesSortedByHireDateAscending(@PathVariable int offset,
                                                                @PathVariable int pageSize){
        return employeeService.employeesSortedByHireDateAscending(offset, pageSize);

    }



//    todo -> ver el drama con la duplicacion de key
    @GetMapping("/setmanager/{manager}/{employee}")
    public void setManager(@PathVariable int manager,
                           @PathVariable int employee){
        employeeService.setManager(manager, employee);
    }


}
