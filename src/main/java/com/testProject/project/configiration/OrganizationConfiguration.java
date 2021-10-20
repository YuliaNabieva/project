package com.testProject.project.configiration;

import com.testProject.project.repository.OrganizationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrganizationConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(OrganizationRepository organizationRepository) {
        return args -> organizationRepository.saveAll();
    }
}

