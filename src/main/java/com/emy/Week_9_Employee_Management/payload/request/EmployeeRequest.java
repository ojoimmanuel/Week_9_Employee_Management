package com.emy.Week_9_Employee_Management.payload.request;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Setter
//@Getter

public class EmployeeRequest {


    private String firstName;

    private String lastName;

    private String email;

    private String password;
}
