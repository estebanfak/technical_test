package com.vortex.challenge.service;

import com.vortex.challenge.model.Department;

public interface DepartmentService {
//    Department addDepartment(String departmentName, Location location) throws Exception;


    Department addDepartment(String departmentName, long locationId) throws Exception;
}
