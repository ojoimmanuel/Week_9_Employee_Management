package com.emy.Week_9_Employee_Management.service.Impl;

import com.emy.Week_9_Employee_Management.entity.Attendance;
import com.emy.Week_9_Employee_Management.entity.Employee;
import com.emy.Week_9_Employee_Management.entity.SalaryByAttendance;
import com.emy.Week_9_Employee_Management.entity.enums.Present;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryByAttendanceResponse;
import com.emy.Week_9_Employee_Management.repository.AttendanceRepository;
import com.emy.Week_9_Employee_Management.repository.EmployeeRepository;
import com.emy.Week_9_Employee_Management.repository.SalaryByAttendanceRepository;
import com.emy.Week_9_Employee_Management.service.SalaryByAttendanceService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Builder
@RequiredArgsConstructor
public class SalaryByAttendanceServiceImpl implements SalaryByAttendanceService {

    private static final double dailyWage = 100.0;
    private final SalaryByAttendanceRepository salaryByAttendanceRepository;
    private final EmployeeRepository employeeRepository;
    private final AttendanceRepository attendanceRepository;

    @Override
    public ResponseEntity<ApiResponse<SalaryByAttendanceResponse>> calculateAndAddSalary(Long employeeId, String salaryMonth, String salaryYear) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        // Fetch attendance records for the given month and year
        List<Attendance> attendances = attendanceRepository.findAttendanceByEmployeeId(employeeId).stream()
                .filter(a -> a.getCreatedAt().getMonth().name().equalsIgnoreCase(salaryMonth) &&
                        String.valueOf(a.getCreatedAt().getYear()).equals(salaryYear))
                .toList();

        long daysPresent = attendances.stream().filter(a -> a.getPresent() == Present.YES).count();
        double totalSalary = daysPresent * dailyWage;

        // Build Salary entity
        SalaryByAttendance salaryByAttendance = SalaryByAttendance.builder()
                .amountByAttendance(BigDecimal.valueOf(totalSalary))
                .salaryMonth(salaryMonth)
                .salaryYear(salaryYear)
                .employee(employee)
                .build();

        // Save salary record
        salaryByAttendanceRepository.save(salaryByAttendance);

        // Build response
        SalaryByAttendanceResponse response = SalaryByAttendanceResponse.builder()
                .amountByAttendance(BigDecimal.valueOf(totalSalary))
                .salaryMonth(salaryMonth)
                .salaryYear(salaryYear)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Salary calculated and saved successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<List<SalaryByAttendanceResponse>>> getAttendanceSalaryByEmployeeId(Long employeeId) {
        List<SalaryByAttendance> salaries = salaryByAttendanceRepository.findAttendanceSalaryByEmployeeId(employeeId);

        List<SalaryByAttendanceResponse> responses = salaries.stream()
                .map(salary -> SalaryByAttendanceResponse.builder()
                        .amountByAttendance(salary.getAmountByAttendance())
                        .salaryMonth(salary.getSalaryMonth())
                        .salaryYear(salary.getSalaryYear())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Salary records retrieved successfully", responses));
    }
}
