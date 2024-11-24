package com.emy.Week_9_Employee_Management.service;

import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryByAttendanceResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalaryByAttendanceService {

    ResponseEntity<ApiResponse<SalaryByAttendanceResponse>> calculateAndAddSalary(Long employeeId, String salaryMonth, String salaryYear);

    ResponseEntity<ApiResponse<List<SalaryByAttendanceResponse>>> getAttendanceSalaryByEmployeeId(Long employeeId);
}
