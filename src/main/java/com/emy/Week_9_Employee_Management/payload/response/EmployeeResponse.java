package com.emy.Week_9_Employee_Management.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String email;
}
