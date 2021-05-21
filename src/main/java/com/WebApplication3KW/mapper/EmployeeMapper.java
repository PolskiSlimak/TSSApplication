package com.WebApplication3KW.mapper;

import com.WebApplication3KW.dto.EmployeeDTO;
import com.WebApplication3KW.model.EmployeeEntity;

public class EmployeeMapper {
    public static EmployeeDTO mapToEmployeeDTO(EmployeeEntity employeeEntity) {
        return EmployeeDTO.builder()
                .employeeId(employeeEntity.getEmployeeId())
                .firstName(employeeEntity.getFirstName())
                .lastName(employeeEntity.getLastName())
                .hireDate(employeeEntity.getHireDate())
                .department(employeeEntity.getDepartmentName())
                .job(employeeEntity.getJobName())
                .build();
    }

    public static EmployeeEntity mapToEmployeeEntity(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setDepartmentName(employeeDTO.getDepartment());
        employeeEntity.setJobName(employeeDTO.getJob());
        employeeEntity.setHireDate(employeeDTO.getHireDate());
        return employeeEntity;
    }

    public static void overrideEmployeeEntity(EmployeeEntity employeeEntity, EmployeeDTO employeeDTO) {
        employeeEntity.setFirstName(employeeDTO.getFirstName());
        employeeEntity.setLastName(employeeDTO.getLastName());
        employeeEntity.setDepartmentName(employeeDTO.getDepartment());
        employeeEntity.setJobName(employeeDTO.getJob());
        employeeEntity.setHireDate(employeeDTO.getHireDate());
    }
}
