package com.vortex.challenge.service.Impl;

import com.vortex.challenge.model.Department;
import com.vortex.challenge.model.Employee;
import com.vortex.challenge.model.Location;
import com.vortex.challenge.repository.DepartmentRepository;
import com.vortex.challenge.repository.LocationRepository;
import com.vortex.challenge.service.DepartmentService;
import com.vortex.challenge.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private LocationRepository locationRepository;


//    @Override
//    public Department addDepartment(String departmentName, Location location) throws Exception {
//
//        if(averageSalary(location)<1000 && dayOfMonth()<15){
//            departmentRepository.save(new Department(departmentName, location));
//        }
//        if(averageSalary(location)<1500 && dayOfMonth()>=15){
//            departmentRepository.save(new Department(departmentName, location));
//        }
//        throw new Exception("Can not insert Department");
//    }
    @Override
    public Department addDepartment(String departmentName, long locationId) throws Exception {

        Location location = locationRepository.findById(locationId).orElse(null);
        validateSalary(location);
        return departmentRepository.save(new Department(departmentName, location));
    }

    private void validateSalary(Location location) throws Exception {
        if(averageSalary(location)>1000 && dayOfMonth()<15){
            throw new Exception("Can not insert Department, average salary must be less than 1000");//AverageSalaryException
        }
        if(averageSalary(location)>1500 && dayOfMonth()>=15){
            throw new Exception("Can not insert Department: average salary must be less than 1500");
        }
    }


    private double averageSalary(Location location){
        List<Employee> employeeList = employeeService
                .getAllEmployeesList()
                .stream()
                .filter(emp -> emp.getDepartmentId().getLocationId().equals(location))
                .toList();
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
