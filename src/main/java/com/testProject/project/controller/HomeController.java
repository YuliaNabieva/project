package com.testProject.project.controller;

import com.testProject.project.entity.Organization;
import com.testProject.project.repository.OrganizationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class HomeController {
    OrganizationRepository organizationRepository;

    @GetMapping("v1/home")
    public String main(Map<String, Object> model) {
        Iterable<Organization> organizations = organizationRepository.findAll();
        model.put("organizations", organizations);
        return "home";
    }
}
