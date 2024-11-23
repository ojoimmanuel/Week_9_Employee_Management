package com.emy.Week_9_Employee_Management.controller;

import com.emy.Week_9_Employee_Management.payload.request.LeaveRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.LeaveResponse;
import com.emy.Week_9_Employee_Management.service.LeaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/leave")
@RequiredArgsConstructor
public class LeaveController {

    private final LeaveService leaveService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<LeaveResponse>> applyLeave(
            @RequestBody LeaveRequest request) {
        return leaveService.addLeave(request);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<ApiResponse<List<LeaveResponse>>> getLeavesByEmployeeId(
            @PathVariable Long employeeId) {
        return leaveService.getLeavesByEmployeeId(employeeId);
    }
}
