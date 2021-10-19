package com.testProject.project.service;

import com.testProject.project.entity.Assignment;
import com.testProject.project.entity.Employee;
import com.testProject.project.repository.AssignmentRepository;
import com.testProject.project.repository.EmployeeRepository;
import com.testProject.project.response.RestApiException;

import java.util.List;
import java.util.Optional;

public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> list() {
        return employeeRepository.findAll();
    }

    public void add(Employee employee) {
        if (employeeRepository.findByLastName(employee.getLastName()).isPresent()) {
            throw new RestApiException("Subject is created");
        }
        employeeRepository.save(employee);
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public void update(Employee employee) {
        Optional<Assignment> row = employeeRepository.findByLastName(employee.getLastName());
        if (row.isPresent()) {
            Assignment item = row.get();
            if (!employee.getLastName()).isEmpty()) {
                item.setSubject(employee.getLastName());
            }
            if (!employee.getFirstName().isEmpty()) {
                item.setFir(employee.getExecutionSign());
            }
            if (employee.getDeadline() != null) {
                item.setDeadline(employee.getDeadline());
            }
            assignmentRepository.save(item);
        }

    }
}
