package com.testProject.project.controller;

import com.testProject.project.entity.Assignment;
import com.testProject.project.entity.Organization;
import com.testProject.project.service.OrganizationService;
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
@RequestMapping("v1/organizations")
public class OrganizationController {
    private final OrganizationService organizationService;

    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @GetMapping(path = "list")
    public List<Organization> list() {
        return (List<Organization>) organizationService.list();

    }

    @PostMapping(path = "item")
    public Iterable<Organization> add(@RequestBody Organization organization) {
        organizationService.add(organization);
        return organizationService.list();

    }

    @DeleteMapping(path = "item/{organizationId}")
    public void delete(@PathVariable("organizationId") Long organizationId) {
        organizationService.delete(organizationId);

    }

    @PutMapping(path = "item")
    public void delete(@RequestBody Organization organizationId) {
        organizationService.update(organizationId);

    }
}
