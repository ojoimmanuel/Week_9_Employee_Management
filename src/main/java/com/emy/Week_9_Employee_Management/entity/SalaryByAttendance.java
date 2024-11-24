package com.emy.Week_9_Employee_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "salary_by_attendance_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SalaryByAttendance extends BaseClass{

        private BigDecimal amountByAttendance;

        private String salaryMonth;

        private String salaryYear;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        private Employee employee;
}



