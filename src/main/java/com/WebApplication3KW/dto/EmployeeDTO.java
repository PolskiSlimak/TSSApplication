package com.WebApplication3KW.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class EmployeeDTO {
    private Integer employeeId;
    private String firstName;
    private String lastName;
    @DateTimeFormat (pattern = "yyyy-MM-dd")
    private LocalDate hireDate;
    private String department;
    private String job;
}
