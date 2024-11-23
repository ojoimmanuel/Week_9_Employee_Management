package com.emy.Week_9_Employee_Management.payload.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequest {

    private BigDecimal amount;

    private String salaryMonth;

    private String salaryYear;

    private Long employeeId;
}
