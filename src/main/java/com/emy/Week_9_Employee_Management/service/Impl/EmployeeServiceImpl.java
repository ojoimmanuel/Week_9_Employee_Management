package com.emy.Week_9_Employee_Management.service.Impl;

import com.emy.Week_9_Employee_Management.entity.Employee;
import com.emy.Week_9_Employee_Management.entity.enums.Roles;
import com.emy.Week_9_Employee_Management.payload.request.EmployeeRequest;
import com.emy.Week_9_Employee_Management.payload.response.ApiResponse;
import com.emy.Week_9_Employee_Management.payload.response.EmployeeResponse;
import com.emy.Week_9_Employee_Management.repository.EmployeeRepository;
import com.emy.Week_9_Employee_Management.service.EmployeeService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Builder
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> registerEmployee(EmployeeRequest request) {

       boolean isEmailPresent = employeeRepository.existsByEmail(request.getEmail());

       if(isEmailPresent) {
           throw new RuntimeException("Email already exists");
       }

       Employee newEmployee = Employee.builder()
               .firstName(request.getFirstName())
               .lastName(request.getLastName())
               .email(request.getEmail())
               .password(request.getPassword())
               .roles(Roles.USER)
               .build();

       employeeRepository.save(newEmployee);

       EmployeeResponse response = EmployeeResponse.builder()
               .firstName(request.getFirstName())
               .lastName(request.getLastName())
               .email(request.getEmail())
               .build();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>("Account Created Successfully", response));
    }

    @Override
    public ResponseEntity<ApiResponse<EmployeeResponse>> findEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        EmployeeResponse response = EmployeeResponse.builder()
                .firstName(employee.getFirstName())
                .lastName(employee.getLastName())
                .email(employee.getEmail())
                .build();

        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>("Employee retrieved successfully", response));
    }
}
