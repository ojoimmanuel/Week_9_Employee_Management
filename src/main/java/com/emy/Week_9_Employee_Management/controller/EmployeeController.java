package com.emy.Week_9_Employee_Management.controller;

import com.emy.Week_9_Employee_Management.payload.request.EmployeeRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.EmployeeResponse;
import com.emy.Week_9_Employee_Management.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee/")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("register")
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee (
            @RequestBody EmployeeRequest request) {

        return employeeService.registerEmployee(request);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<EmployeeResponse>> getEmployeeById (
            @PathVariable Long employeeId) {

        return employeeService.findEmployeeById(employeeId);
    }
    

}
