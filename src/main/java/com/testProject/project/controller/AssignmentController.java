package com.testProject.project.controller;

import com.testProject.project.entity.Assignment;
import com.testProject.project.service.AssignmentService;
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
@RequestMapping("v1/assignments")
public class AssignmentController {
    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping(path = "list")
    public List<Assignment> list() {
        return assignmentService.list();

    }
    @PostMapping(path = "item")
    public List<Assignment> add(@RequestBody Assignment assignment) {
        assignmentService.add(assignment);
        return assignmentService.list();

    }
    @DeleteMapping(path = "item/{assignmentId}")
    public void delete(@PathVariable("assignmentId") Long assignmentId) {
        assignmentService.delete(assignmentId);

    }
    @PutMapping(path = "item")
    public void delete(@RequestBody Assignment assignmentId) {
        assignmentService.update(assignmentId);

    }
}
