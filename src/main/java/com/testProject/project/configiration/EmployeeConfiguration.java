package com.testProject.project.configiration;

import com.testProject.project.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfiguration {
    @Bean
    public CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository) {
        return args -> employeeRepository.saveAll();
    }

}
