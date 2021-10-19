package com.testProject.project.repository;

import com.testProject.project.entity.Organization;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    Optional<Object> findByNameOrg(String nameOrg);
    void saveAll();
}
