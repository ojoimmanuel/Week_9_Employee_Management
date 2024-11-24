package com.emy.Week_9_Employee_Management.service;

import com.emy.Week_9_Employee_Management.payload.request.SalaryRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SalaryService {

    ResponseEntity<ApiResponse<SalaryResponse>> addSalary(SalaryRequest request);

    ResponseEntity<ApiResponse<List<SalaryResponse>>> getSalaryByEmployeeId(Long employeeId);

}
