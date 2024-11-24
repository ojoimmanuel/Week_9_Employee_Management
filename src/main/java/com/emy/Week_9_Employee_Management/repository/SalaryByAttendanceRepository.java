package com.emy.Week_9_Employee_Management.repository;

import com.emy.Week_9_Employee_Management.entity.SalaryByAttendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryByAttendanceRepository extends JpaRepository<SalaryByAttendance, Long> {

    List<SalaryByAttendance> findAttendanceSalaryByEmployeeId(Long employeeId);
}
