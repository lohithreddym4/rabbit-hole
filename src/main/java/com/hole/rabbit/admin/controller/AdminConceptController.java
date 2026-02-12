package com.hole.rabbit.admin.controller;

import com.hole.rabbit.concept.dto.CreateConceptDTO;
import com.hole.rabbit.concept.service.ConceptService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/concepts")
@RequiredArgsConstructor
public class AdminConceptController {

    private final ConceptService conceptService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createConcept(@RequestBody CreateConceptDTO dto) {
        return conceptService.createConcept(dto);
    }

    @PatchMapping("/{id}/publish")
    public void publishConcept(@PathVariable String id) {
        conceptService.publishConcept(id);
    }

}
