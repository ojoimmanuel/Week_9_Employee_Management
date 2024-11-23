package com.emy.Week_9_Employee_Management.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "salary_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Salary extends BaseClass {

    private BigDecimal amount;

    private String salaryMonth;

    private String salaryYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;
}

