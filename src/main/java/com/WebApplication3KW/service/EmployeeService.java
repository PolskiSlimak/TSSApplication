package com.WebApplication3KW.service;

import com.WebApplication3KW.dto.EmployeeDTO;
import com.WebApplication3KW.mapper.EmployeeMapper;
import com.WebApplication3KW.model.EmployeeEntity;
import com.WebApplication3KW.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<EmployeeDTO> getEmployeeList() {
        List<EmployeeEntity> employees = employeeRepository.findAll();
        return mapToDTOList(employees);
    }

    public void addEmployee(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = EmployeeMapper.mapToEmployeeEntity(employeeDTO);
        employeeRepository.save(employeeEntity);
    }

    public void deleteEmployee(int index) {
        employeeRepository.deleteById(index);
    }

    private List<EmployeeDTO> mapToDTOList(List<EmployeeEntity> employees) {
        List<EmployeeDTO> employeesDTO = new ArrayList<>();
        for (EmployeeEntity employeeEntity : employees) {
            EmployeeDTO employeeDTO = EmployeeMapper.mapToEmployeeDTO(employeeEntity);
            employeesDTO.add(employeeDTO);
        }
        return employeesDTO;
    }
}
