package com.emy.Week_9_Employee_Management.entity;

import com.emy.Week_9_Employee_Management.entity.enums.Absent;
import com.emy.Week_9_Employee_Management.entity.enums.Present;
import com.emy.Week_9_Employee_Management.entity.enums.Reasons;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "attendance_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Attendance extends BaseClass {

    @Enumerated(EnumType.STRING)  //helps to see string rather than numbers in DB
    private Present present;

    @Enumerated(EnumType.STRING)  //helps to see string rather than numbers in DB
    private Absent absent;

    @Enumerated(EnumType.STRING)
    private Reasons reasons;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
