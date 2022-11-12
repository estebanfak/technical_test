package com.vortex.challenge.repository;

import com.vortex.challenge.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByDepartmentId(short departmentId);
    Department findByDepartmentName(String departmentName);
}
