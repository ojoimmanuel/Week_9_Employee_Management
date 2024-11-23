package com.emy.Week_9_Employee_Management.service;

import com.emy.Week_9_Employee_Management.payload.request.AttendanceRequest;
import com.emy.Week_9_Employee_Management.payload.request.EmployeeRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.AttendanceResponse;
import com.emy.Week_9_Employee_Management.payload.response.EmployeeResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AttendanceService {

//    AttendanceResponse registerAttendance (AttendanceRequest request);
    ResponseEntity<ApiResponse<AttendanceResponse>> addAttendance(AttendanceRequest request);

    ResponseEntity<ApiResponse<List<AttendanceResponse>>> getAttendanceByEmployeeId(Long employeeId);

}
