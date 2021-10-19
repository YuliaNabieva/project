package com.testProject.project.controller;

import com.testProject.project.entity.Employee;
import com.testProject.project.repository.EmployeeRepository;
import com.testProject.project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "list")
    public List<Employee> list() {
        return EmployeeService.list();

    }

    @PostMapping(path = "item")
    public List<Employee> add(@RequestBody Employee employee) {
        EmployeeService.add(employee);
        return EmployeeService.list();

    }

    @DeleteMapping(path = "item/{employeeId}")
    public void delete(@PathVariable("assignmentId") Long employeeId) {
        EmployeeService.delete(employeeId);

    }

    @PutMapping(path = "item")
    public void delete(@RequestBody Employee employeeId) {
        EmployeeService.update(employeeId);

    }
}
