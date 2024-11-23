package com.emy.Week_9_Employee_Management.repository;

import com.emy.Week_9_Employee_Management.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {

    List<Salary> findSalaryByEmployeeId(Long employeeId);
}
