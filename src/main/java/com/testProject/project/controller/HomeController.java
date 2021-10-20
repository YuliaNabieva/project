package com.testProject.project.controller;

import com.testProject.project.entity.Assignment;
import com.testProject.project.entity.Organization;
import com.testProject.project.repository.AssignmentRepository;
import com.testProject.project.repository.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {
    OrganizationRepository organizationRepository;
    AssignmentRepository assignmentRepository;

    @GetMapping("v1/home")
    public String mainOrganizations(Map<String, Object> model) {
        Iterable<Organization> organizations = organizationRepository.findAll();
        model.put("organizations", organizations);
        return "home";
    }

    @GetMapping("v1/home")
    public String mainAssignments(Map<String, Object> model) {
        Iterable<Assignment> assignments = assignmentRepository.findAll();
        model.put("assignments", assignments);
        return "home";
    }

}
