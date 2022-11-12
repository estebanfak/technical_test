package com.vortex.challenge.repository;

import com.vortex.challenge.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Optional<Department> findByDepartmentId(short departmentId);
    Department findByDepartmentName(String departmentName);
}
