package com.emy.Week_9_Employee_Management.repository;

import com.emy.Week_9_Employee_Management.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LeaveRepository extends JpaRepository<Leave, Long> {

    List<Leave> findLeaveByEmployeeId (Long employeeId);
}
