package com.emy.Week_9_Employee_Management.entity;

import com.emy.Week_9_Employee_Management.entity.enums.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity    //mark class as JPA entity that should map to a DB
@Table(name = "employee_tbl")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Employee extends BaseClass {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    @Enumerated(EnumType.STRING)
    private Roles roles;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Attendance> attendances;

}
