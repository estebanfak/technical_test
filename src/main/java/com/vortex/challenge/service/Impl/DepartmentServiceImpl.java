package com.vortex.challenge.service.Impl;

import com.vortex.challenge.constant.Messages;
import com.vortex.challenge.exception.AverageSalaryException;
import com.vortex.challenge.exception.DepartmentNotFoundException;
import com.vortex.challenge.exception.LocationNotFoundException;
import com.vortex.challenge.model.Department;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Location;
import com.vortex.challenge.repository.DepartmentRepository;
import com.vortex.challenge.service.DepartmentService;
import com.vortex.challenge.service.EmployeeService;
import com.vortex.challenge.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LocationService locationService;




    @Override
    public Department addDepartment(String departmentName, short locationId) throws AverageSalaryException, LocationNotFoundException {
        Location location = locationService.findByLocationId(locationId);
        validateSalary(location);
        return departmentRepository.save(new Department(departmentName, location));
    }

    @Override
    public Department findByDepartmentId(short departmentId) throws DepartmentNotFoundException {
        return departmentRepository.findByDepartmentId(departmentId).orElseThrow(()-> new DepartmentNotFoundException(Messages.DEPARTMENT_NOT_FOUND));
    }

    private void validateSalary(Location location) throws AverageSalaryException {
        if(averageSalary(location)>1000 && dayOfMonth()<15){
            throw new AverageSalaryException(Messages.SALARY_LESS_THAN_1000);
        }
        if(averageSalary(location)>1500 && dayOfMonth()>=15){
            throw new AverageSalaryException(Messages.SALARY_LESS_THAN_1500);
        }
    }
    private double averageSalary(Location location){
        List<Employee> employeeList = employeeService
                .getAllEmployeesList()
                .stream()
                .filter(emp -> emp.getDepartmentId().getLocationId().equals(location))
                .toList();
        if(employeeList.size()==0){
            return 0;
        }
        return employeeList
                .stream()
                .map(Employee::getSalary)
                .reduce(0.0, Double::sum)
                /
                employeeList.size();
    }
    private int dayOfMonth(){
        return LocalDate.now().getDayOfMonth();
    }
}
