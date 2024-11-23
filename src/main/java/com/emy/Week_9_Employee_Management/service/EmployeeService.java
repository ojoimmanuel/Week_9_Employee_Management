package com.emy.Week_9_Employee_Management.service;

import com.emy.Week_9_Employee_Management.payload.request.EmployeeRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

public interface EmployeeService {

    ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request);

    ResponseEntity<ApiResponse<EmployeeResponse>> findEmployeeById(Long employeeId);
}
