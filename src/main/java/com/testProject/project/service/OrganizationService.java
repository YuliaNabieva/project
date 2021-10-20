package com.testProject.project.service;

import com.testProject.project.entity.Organization;
import com.testProject.project.repository.OrganizationRepository;
import com.testProject.project.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;

    public OrganizationService(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Iterable<Organization> list() {

        return organizationRepository.findAll();
    }

    public void add(Organization organization) {
        if (organizationRepository.findByNameOrg(organization.getNameOrg()).isPresent()) {
            throw new RestApiException("Organization exists");
        }
        organizationRepository.save(organization);
    }

    public void delete(Long organizationId) {
        organizationRepository.deleteById(organizationId);
    }

    public void update(Organization organization) {
        Optional<Organization> row = organizationRepository.findById(organization.getId());
        if (row.isPresent()) {
            Organization item = row.get();
            if (!organization.getFizAdressOrg().isEmpty()) {
                item.setFizAdressOrg(organization.getFizAdressOrg());
            }
            if (!organization.getUrAdressOrg().isEmpty()) {
                item.setUrAdressOrg(organization.getUrAdressOrg());
            }
            if (!organization.getNameOrg().isEmpty()) {
                item.setNameOrg(organization.getNameOrg());
            }
            if (organization.getSupervisorOrg() != null) {
                item.setSupervisorOrg(organization.getSupervisorOrg());
            }
            organizationRepository.save(item);
        }

    }
}
