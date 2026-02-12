package com.hole.rabbit.concept.controller;

import com.hole.rabbit.concept.dto.ConceptResponseDTO;
import com.hole.rabbit.concept.service.ConceptService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/concepts")
@RequiredArgsConstructor
public class ConceptController {

    private final ConceptService conceptService;

    @GetMapping("/{id}")
    public ConceptResponseDTO getConcept(@PathVariable String id) {
        return conceptService.getConceptById(id);
    }
}
