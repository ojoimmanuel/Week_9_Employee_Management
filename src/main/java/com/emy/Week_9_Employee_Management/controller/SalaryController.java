package com.emy.Week_9_Employee_Management.controller;

import com.emy.Week_9_Employee_Management.payload.request.SalaryRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryResponse;
import com.emy.Week_9_Employee_Management.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<SalaryResponse>> addSalary(@RequestBody SalaryRequest request) {
        return salaryService.addSalary(request);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<List<SalaryResponse>>> getSalaryByEmployeeId(@PathVariable Long employeeId) {
        return salaryService.getSalaryByEmployeeId(employeeId);
    }
}
