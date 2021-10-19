package com.testProject.project.repository;

import com.testProject.project.entity.Subdivision;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SubdivisionRepository extends CrudRepository<Subdivision, Long> {
    Optional<Object> findByNameSubdivision(String nameSubdivision);
    void saveAll();
}
