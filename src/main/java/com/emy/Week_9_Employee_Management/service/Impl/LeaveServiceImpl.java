package com.emy.Week_9_Employee_Management.service.Impl;

import com.emy.Week_9_Employee_Management.entity.Employee;
import com.emy.Week_9_Employee_Management.entity.Leave;
import com.emy.Week_9_Employee_Management.payload.request.LeaveRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.LeaveResponse;
import com.emy.Week_9_Employee_Management.repository.EmployeeRepository;
import com.emy.Week_9_Employee_Management.repository.LeaveRepository;
import com.emy.Week_9_Employee_Management.service.LeaveService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor
public class LeaveServiceImpl implements LeaveService {

    private final LeaveRepository leaveRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ApiResponse<LeaveResponse>> addLeave(LeaveRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Leave leave = Leave.builder()
                .leaveType(request.getLeaveType())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .employee(employee)
                .build();

        leaveRepository.save(leave);

        LeaveResponse response = LeaveResponse.builder()
                .leaveType(request.getLeaveType())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Leave applied successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<List<LeaveResponse>>> getLeavesByEmployeeId(Long employeeId) {
        List<Leave> leaves = leaveRepository.findLeaveByEmployeeId(employeeId);

        List<LeaveResponse> responses = leaves.stream()
                .map(leave -> LeaveResponse.builder()
                        .leaveType(leave.getLeaveType())
                        .startDate(leave.getStartDate())
                        .endDate(leave.getEndDate())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Leave records retrieved successfully", responses));
    }
}