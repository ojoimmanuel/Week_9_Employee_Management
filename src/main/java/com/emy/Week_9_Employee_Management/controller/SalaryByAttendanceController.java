package com.emy.Week_9_Employee_Management.controller;

import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryByAttendanceResponse;
import com.emy.Week_9_Employee_Management.service.SalaryByAttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/salary_by_attendance")
@RequiredArgsConstructor
public class SalaryByAttendanceController {

    private final SalaryByAttendanceService salaryByAttendanceService;


    @PostMapping("/calculate/{employeeId}")
    public ResponseEntity<ApiResponse<SalaryByAttendanceResponse>> calculateSalary(
            @PathVariable Long employeeId,
            @RequestParam String salaryMonth,
            @RequestParam String salaryYear) {
        return salaryByAttendanceService.calculateAndAddSalary(employeeId, salaryMonth, salaryYear);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<List<SalaryByAttendanceResponse>>> getSalaryByEmployeeId(@PathVariable Long employeeId) {
        return salaryByAttendanceService.getAttendanceSalaryByEmployeeId(employeeId);
    }


}
