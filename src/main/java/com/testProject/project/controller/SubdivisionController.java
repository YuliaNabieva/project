package com.testProject.project.controller;

import com.testProject.project.entity.Subdivision;
import com.testProject.project.service.SubdivisionService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/subdivisions")
public class SubdivisionController {
    private final SubdivisionService subdivisionService;

    public SubdivisionController(SubdivisionService subdivisionService) {
        this.subdivisionService = subdivisionService;
    }

    @GetMapping(path = "list")
    public List<Subdivision> list() {
        return (List<Subdivision>) subdivisionService.list();

    }

    @PostMapping(path = "item")
    public Iterable<Subdivision> add(@RequestBody Subdivision subdivision) {
        subdivisionService.add(subdivision);
        return subdivisionService.list();

    }

    @DeleteMapping(path = "item/{subdivisionId}")
    public void delete(@PathVariable("subdivisionId") Long subdivisionId) {
        subdivisionService.delete(subdivisionId);

    }

    @PutMapping(path = "item")
    public void delete(@RequestBody Subdivision subdivision) {
        subdivisionService.update(subdivision);

    }
}
