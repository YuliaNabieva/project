package com.testProject.project.configiration;

import com.testProject.project.repository.SubdivisionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SubdivisionConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(SubdivisionRepository subdivisionRepository) {
        return args -> subdivisionRepository.saveAll();
    }
}

