package com.testProject.project.repository;

import com.testProject.project.entity.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findAssignmentBySubject(String subject);

    void saveAll();
}

