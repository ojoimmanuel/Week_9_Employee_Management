package com.emy.Week_9_Employee_Management.payload.request;

import com.emy.Week_9_Employee_Management.entity.enums.LeaveType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    private LeaveType leaveType;

    private LocalDate startDate;

    private LocalDate endDate;

    private Long employeeId;
}
