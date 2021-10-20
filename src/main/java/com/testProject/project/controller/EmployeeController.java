package com.testProject.project.controller;

import com.testProject.project.entity.Employee;
import com.testProject.project.repository.EmployeeRepository;
import com.testProject.project.service.EmployeeService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "list")
    public Iterable<Employee> list() {
        return employeeService.list();
    }

    @PostMapping(path = "item")
    public Iterable<Employee> add(@RequestBody Employee employee) {
        employeeService.add(employee);
        return employeeService.list();
    }

    @DeleteMapping(path = "item/{employeeId}")
    public void delete(@PathVariable("assignmentId") Long employeeId) {
        employeeService.delete(employeeId);
    }

    @PutMapping(path = "item")
    public void delete(@RequestBody Employee employeeId) {
        employeeService.update(employeeId);
    }
}
