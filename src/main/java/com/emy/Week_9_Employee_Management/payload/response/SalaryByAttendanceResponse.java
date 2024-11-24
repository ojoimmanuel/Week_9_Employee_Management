package com.emy.Week_9_Employee_Management.payload.response;

import lombok.*;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SalaryByAttendanceResponse {

    private BigDecimal amountByAttendance;

    private String salaryMonth;

    private String salaryYear;
}

