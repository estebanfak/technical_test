package com.vortex.challenge.repository;

import com.vortex.challenge.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Optional<Employee> findByEmployeeId(int id);
    Page<Employee> findByJobIdJobId(int id, Pageable pageable);
    Page<Employee> findByManagerId(Employee managerId, Pageable pageable);
    Employee findByLastName(String lastName);
    Page<Employee> findByLastName(String lastName, Pageable pageable);
}
