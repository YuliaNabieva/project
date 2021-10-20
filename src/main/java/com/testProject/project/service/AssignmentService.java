package com.testProject.project.service;

import com.testProject.project.entity.Assignment;
import com.testProject.project.repository.AssignmentRepository;
import com.testProject.project.repository.EmployeeRepository;
import com.testProject.project.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final EmployeeRepository employeeRepository;
    private Object Employee;

    public AssignmentService(AssignmentRepository assignmentRepository, EmployeeRepository employeeRepository) {
        this.assignmentRepository = assignmentRepository;
        this.employeeRepository = employeeRepository;
    }

    public List<Assignment> list() {

        return assignmentRepository.findAll();
    }

    public void add(Assignment assignment) {
        if (assignmentRepository.findAssignmentBySubject(assignment.getSubject()).isPresent()) {
            Optional<Assignment> row = assignmentRepository.findById(assignment.getId());
            if (row.isPresent()) {
                Assignment supervisor = row.get();
                Assignment performer = row.get();
                if (assignment.getAuthorOfAssigment() == null) {
                    supervisor.setAuthorOfAssigment(assignment.getAuthorOfAssigment());
                }
                if (assignment.getPerformersOfAssigment() == null) {
                    performer.setPerformersOfAssigment(assignment.getPerformersOfAssigment());
                }
                if (assignment.getControlSign() == null) {
                    assignment.setControlSign(assignment.getControlSign());
                }
                if (assignment.getExecutionSign() == null) {
                    assignment.setExecutionSign(assignment.getControlSign());
                }

                throw new RestApiException("Assignment exists");
            }
        }
        assignmentRepository.save(assignment);
    }

    public void delete(Long assignmentId) {
        assignmentRepository.deleteById(assignmentId);
    }

    public void update(Assignment assignment) {
        Optional<Assignment> row = assignmentRepository.findById(assignment.getId());
        if (row.isPresent()) {
            Assignment item = row.get();
            if (!assignment.getSubject().isEmpty()) {
                item.setSubject(assignment.getSubject());
            }
            if (!assignment.getControlSign().isEmpty()) {
                item.setExecutionSign(assignment.getExecutionSign());
            }
            if (assignment.getDeadline() != null) {
                item.setDeadline(assignment.getDeadline());
            }
            assignmentRepository.save(item);
        }

    }
}
