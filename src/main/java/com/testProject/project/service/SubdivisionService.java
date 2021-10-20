package com.testProject.project.service;


import com.testProject.project.entity.Organization;
import com.testProject.project.entity.Subdivision;
import com.testProject.project.repository.SubdivisionRepository;
import com.testProject.project.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubdivisionService {
    private final SubdivisionRepository subdivisionRepository;

    public SubdivisionService(SubdivisionRepository subdivisionRepository) {
        this.subdivisionRepository = subdivisionRepository;
    }

    public Iterable<Subdivision> list() {

        return subdivisionRepository.findAll();
    }

    public void add(Subdivision subdivision) {
        if (subdivisionRepository.findByNameSubdivision(subdivision.getNameSubdivision()).isPresent()) {
            throw new RestApiException("Subdivision exists");
        }
        subdivisionRepository.save(subdivision);
    }

    public void delete(Long subdivisionId) {
        subdivisionRepository.deleteById(subdivisionId);
    }

    public void update(Subdivision subdivision) {
        Optional<Subdivision> row = subdivisionRepository.findById(subdivision.getId());
        if (row.isPresent()) {
            Subdivision item = row.get();
            if (!subdivision.getNameSubdivision().isEmpty()) {
                item.setNameSubdivision(subdivision.getNameSubdivision());
            }
            if (!subdivision.getContactsSubdivision().isEmpty()) {
                item.setContactsSubdivision(subdivision.getContactsSubdivision());
            }

            subdivisionRepository.save(item);
        }

    }
}
