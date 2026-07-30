package com.accenture.EmployeeManagementMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.accenture.EmployeeManagementMicroservice.entity.Employee;
import com.accenture.EmployeeManagementMicroservice.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/employees")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // GET All Employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    // GET Employee By ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    // POST Employee
    @PostMapping
    public Employee saveEmployee(@Valid @RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    // PUT Employee
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @Valid @RequestBody Employee employee) {

        return employeeService.updateEmployee(id, employee);
    }

    // DELETE Employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        employeeService.deleteEmployee(id);

        return "Employee Deleted Successfully";
    }

}