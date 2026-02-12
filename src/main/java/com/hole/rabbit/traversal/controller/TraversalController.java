package com.hole.rabbit.traversal.controller;


import com.hole.rabbit.concept.dto.ConceptPreviewDTO;
import com.hole.rabbit.concept.model.LinkType;
import com.hole.rabbit.traversal.service.TraversalService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/traverse")
@RequiredArgsConstructor
public class TraversalController {

    private final TraversalService traversalService;

    @GetMapping("/{id}")
    public List<ConceptPreviewDTO> traverse(
            @PathVariable String id,
            @RequestParam LinkType type) {

        return traversalService.traverse(id, type);
    }
}
