package com.emy.Week_9_Employee_Management.repository;

import com.emy.Week_9_Employee_Management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long > {

    boolean existsByEmail(String email);
}
