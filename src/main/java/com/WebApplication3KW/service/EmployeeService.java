package com.WebApplication3KW.service;

import com.WebApplication3KW.dto.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
    private List<EmployeeDTO> employeeDTOList = new ArrayList<>();

    public EmployeeService() {
        initList();
    }

    public void initList() {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName("Adam");
        employeeDTO.setLastName("Kowalski");
        employeeDTO.setHireDate(LocalDate.now());
        employeeDTO.setDepartment("IT");

        EmployeeDTO employeeDTO1 = new EmployeeDTO();
        employeeDTO1.setFirstName("Kamil");
        employeeDTO1.setLastName("Nowak");
        employeeDTO1.setHireDate(LocalDate.now());
        employeeDTO1.setDepartment("HR");

        this.employeeDTOList.add(employeeDTO);
        this.employeeDTOList.add(employeeDTO1);
    }

    public List<EmployeeDTO> getEmployeeDTOList() {
        return this.employeeDTOList;
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        this.employeeDTOList.add(employeeDTO);
    }

    public void deleteEmployee(int index) {
        this.employeeDTOList.remove(index);
    }
}
