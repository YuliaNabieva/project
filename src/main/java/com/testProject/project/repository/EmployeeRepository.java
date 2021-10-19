package com.testProject.project.repository;

import com.testProject.project.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    Optional<Object> findByLastName(String lastName);
    void saveAll();
}
