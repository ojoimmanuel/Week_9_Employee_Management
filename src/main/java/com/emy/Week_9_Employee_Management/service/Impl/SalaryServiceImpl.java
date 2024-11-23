package com.emy.Week_9_Employee_Management.service.Impl;

import com.emy.Week_9_Employee_Management.entity.Employee;
import com.emy.Week_9_Employee_Management.entity.Salary;
import com.emy.Week_9_Employee_Management.payload.request.SalaryRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.SalaryResponse;
import com.emy.Week_9_Employee_Management.repository.EmployeeRepository;
import com.emy.Week_9_Employee_Management.repository.SalaryRepository;
import com.emy.Week_9_Employee_Management.service.SalaryService;
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
public class SalaryServiceImpl implements SalaryService {

    private final SalaryRepository salaryRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ApiResponse<SalaryResponse>> addSalary(SalaryRequest request) {
        Employee employee = employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        Salary salary = Salary.builder()
                .amount(request.getAmount())
                .salaryMonth(request.getSalaryMonth())
                .salaryYear(request.getSalaryYear())
                .employee(employee)
                .build();

        salaryRepository.save(salary);

        SalaryResponse response = SalaryResponse.builder()
                .amount(request.getAmount())
                .salaryMonth(request.getSalaryMonth())
                .salaryYear(request.getSalaryYear())
                .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Salary record created successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<List<SalaryResponse>>> getSalaryByEmployeeId(Long employeeId) {
        List<Salary> salaries = salaryRepository.findSalaryByEmployeeId(employeeId);

        List<SalaryResponse> responses = salaries.stream()
                .map(salary -> SalaryResponse.builder()
                        .amount(salary.getAmount())
                        .salaryMonth(salary.getSalaryMonth())
                        .salaryYear(salary.getSalaryYear())
                        .build())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Salary records retrieved successfully", responses));
    }
}
