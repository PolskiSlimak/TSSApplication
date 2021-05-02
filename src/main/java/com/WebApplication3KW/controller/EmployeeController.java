package com.WebApplication3KW.controller;

import com.WebApplication3KW.dto.EmployeeDTO;
import com.WebApplication3KW.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/")
    public String index(Model model) {
        EmployeeDTO employeeDTO = EmployeeDTO.builder().build();
        model.addAttribute("employees", employeeService.getEmployeeList());
        model.addAttribute("newEmployee", employeeDTO);
        model.addAttribute("appVersion", "1.0");
        model.addAttribute("author", "Wawoczny Kamil");
        return "main-page";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(@ModelAttribute EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
        return "redirect:/";
    }

    @PostMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam(value = "index") Integer index) {
        employeeService.deleteEmployee(index);
        return "redirect:/";
    }
}
