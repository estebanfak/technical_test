package com.vortex.challenge.service;

import com.vortex.challenge.exception.AverageSalaryException;
import com.vortex.challenge.exception.DepartmentNotFoundException;
import com.vortex.challenge.exception.LocationNotFoundException;
import com.vortex.challenge.model.Department;

import java.util.Optional;

public interface DepartmentService {
    Department addDepartment(String departmentName, short locationId) throws AverageSalaryException, LocationNotFoundException;

    Department findByDepartmentId(short departmentId) throws DepartmentNotFoundException;
}
