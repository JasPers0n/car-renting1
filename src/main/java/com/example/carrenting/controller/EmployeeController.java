package com.example.carrenting.controller;

import com.example.carrenting.entity.Employee;
import com.example.carrenting.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee-list")
    public String viewEmployeeList(Model model) {
        model.addAttribute("listEmployees", employeeService.getAll());
        return "/employee/employee-list";
    }

    @GetMapping("/showAddEmployeeForm")
    public String showAddEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employee/employee-add-form";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employee/employee-list";
    }

    @GetMapping("/showEmployeeUpdateForm/{id}")
    public String showEmployeeUpdateForm(@PathVariable long id, Model model) {
        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);
        return "/employee/employee-update-form";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable long id) {
        employeeService.deleteEmployeeById(id);
        return "redirect:/employee/employee-list";
    }
}