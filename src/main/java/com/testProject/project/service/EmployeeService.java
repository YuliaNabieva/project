package com.testProject.project.service;

import com.testProject.project.entity.Employee;
import com.testProject.project.repository.EmployeeRepository;
import com.testProject.project.response.RestApiException;

import java.util.List;
import java.util.Optional;


public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> list() {

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
        Optional<Employee> row = employeeRepository.findById(employee.getId());
        if (row.isPresent()) {
            Employee item = row.get();
            if (employee.getId().equals(item.getId())) {
                item.setLastName(employee.getLastName());
            }
            if (!employee.getFirstName().isEmpty()) {
                item.setFirstName(employee.getFirstName());
            }

            employeeRepository.save(item);
        }

    }

}
