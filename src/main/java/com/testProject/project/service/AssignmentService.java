package com.testProject.project.service;

import com.testProject.project.entity.Assignment;
import com.testProject.project.repository.AssignmentRepository;
import com.testProject.project.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignmentService {
    private final AssignmentRepository assignmentRepository;

    public AssignmentService(AssignmentRepository assignmentRepository) {
        this.assignmentRepository = assignmentRepository;
    }

    public List<Assignment> list() {

        return assignmentRepository.findAll();
    }

    public void add(Assignment assignment) {
        if (assignmentRepository.findAssignmentBySubject(assignment.getSubject()).isPresent()) {
            throw new RestApiException("Subject is not found");
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
