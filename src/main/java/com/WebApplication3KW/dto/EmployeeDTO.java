package com.WebApplication3KW.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Setter
@Getter
public class EmployeeDTO {
    private String firstName;
    private String lastName;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    private String department;
}
