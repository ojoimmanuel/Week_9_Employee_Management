package com.emy.Week_9_Employee_Management.repository;

import com.emy.Week_9_Employee_Management.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    List<Attendance> findAttendanceByEmployeeId(Long employeeId);
}
