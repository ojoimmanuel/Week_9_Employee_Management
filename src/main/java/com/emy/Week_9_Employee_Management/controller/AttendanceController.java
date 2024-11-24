package com.emy.Week_9_Employee_Management.controller;

import com.emy.Week_9_Employee_Management.payload.request.AttendanceRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.AttendanceResponse;
import com.emy.Week_9_Employee_Management.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping("/add_attendance")
    public ResponseEntity<ApiResponse<AttendanceResponse>> addAttendance (
            @RequestBody AttendanceRequest request) {

        return attendanceService.addAttendance(request);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<List<AttendanceResponse>>> getAttendanceById (
            @PathVariable Long employeeId) {

        return attendanceService.getAttendanceByEmployeeId(employeeId);
    }
}
