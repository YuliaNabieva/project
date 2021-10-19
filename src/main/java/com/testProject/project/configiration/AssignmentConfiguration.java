package com.testProject.project.configiration;

import com.testProject.project.repository.AssignmentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AssignmentConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(AssignmentRepository assignmentRepository){
        return args -> assignmentRepository.saveAll();
    }
}
