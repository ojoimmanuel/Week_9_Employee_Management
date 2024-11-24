package com.emy.Week_9_Employee_Management.service.Impl;

import com.emy.Week_9_Employee_Management.entity.Attendance;
import com.emy.Week_9_Employee_Management.entity.Employee;
import com.emy.Week_9_Employee_Management.payload.request.AttendanceRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.AttendanceResponse;
import com.emy.Week_9_Employee_Management.repository.AttendanceRepository;
import com.emy.Week_9_Employee_Management.repository.EmployeeRepository;
import com.emy.Week_9_Employee_Management.service.AttendanceService;
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
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ApiResponse<AttendanceResponse>> addAttendance(AttendanceRequest request) {

        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Attendance attendance = Attendance.builder()
                .present(request.getPresent())
                .absent(request.getAbsent())
                .reasons(request.getReasons())
                .employee(employee)
                .build();

        attendanceRepository.save(attendance);

        AttendanceResponse attendanceResponse = AttendanceResponse.builder()
                .present(request.getPresent())
                .absent(request.getAbsent())
                .reasons(request.getReasons())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Attendance logged successfully", attendanceResponse));
    }

    @Override
    public ResponseEntity<ApiResponse<List<AttendanceResponse>>> getAttendanceByEmployeeId(Long employeeId) {

        List<Attendance> attendances = attendanceRepository.findAttendanceByEmployeeId(employeeId);

        List<AttendanceResponse> attendanceResponses = attendances.stream()
                .map(attendance -> AttendanceResponse.builder()
                        .present(attendance.getPresent())
                        .absent(attendance.getAbsent())
                        .reasons(attendance.getReasons())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Attendance fetched successfully", attendanceResponses));

    }
}
