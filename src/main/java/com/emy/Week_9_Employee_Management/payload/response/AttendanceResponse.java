package com.emy.Week_9_Employee_Management.payload.response;

import com.emy.Week_9_Employee_Management.entity.enums.Absent;
import com.emy.Week_9_Employee_Management.entity.enums.Present;
import com.emy.Week_9_Employee_Management.entity.enums.Reasons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendanceResponse {

    private Present present;

    private Absent absent;

    private Reasons reasons;
}
