package com.hole.rabbit.concept.service;

import com.hole.rabbit.concept.dto.*;
import com.hole.rabbit.concept.model.Concept;
import com.hole.rabbit.concept.model.ConceptStatus;
import com.hole.rabbit.concept.repository.ConceptRepository;
import com.hole.rabbit.exception.ConceptNotFoundException;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConceptServiceImpl implements ConceptService {

    private final ConceptRepository conceptRepository;

    @Override
    public ConceptResponseDTO getConceptById(String id) {

        Concept concept = conceptRepository
                .findByIdAndStatus(id, ConceptStatus.PUBLISHED)
                .orElseThrow(() -> new ConceptNotFoundException("Concept not found"));

        return mapToResponse(concept);
    }

    @Override
    public String createConcept(CreateConceptDTO dto) {

        Concept concept = Concept.builder()
                .title(dto.getTitle())
                .coreInsight(dto.getCoreInsight())
                .whyItMatters(dto.getWhyItMatters())
                .difficulty(dto.getDifficulty())
                .gravityScore(0.0) // default
                .deeper(dto.getDeeper())
                .wider(dto.getWider())
                .origin(dto.getOrigin())
                .failure(dto.getFailure())
                .provocativeQuestion(dto.getProvocativeQuestion())
                .status(ConceptStatus.DRAFT) // ALWAYS start as draft
                .build();

        Concept saved = conceptRepository.save(concept);

        return saved.getId();
    }

    private ConceptResponseDTO mapToResponse(Concept concept) {

        return ConceptResponseDTO.builder()
                .id(concept.getId())
                .title(concept.getTitle())
                .coreInsight(concept.getCoreInsight())
                .whyItMatters(concept.getWhyItMatters())
                .difficulty(concept.getDifficulty())
                .provocativeQuestion(concept.getProvocativeQuestion())
                .deeper(mapPreview(concept.getDeeper()))
                .wider(mapPreview(concept.getWider()))
                .origin(mapPreview(concept.getOrigin()))
                .failure(mapPreview(concept.getFailure()))
                .build();
    }

    private List<ConceptPreviewDTO> mapPreview(List<String> ids) {

        if (ids == null || ids.isEmpty())
            return List.of();

        List<Concept> concepts = conceptRepository.findByIdInAndStatus(ids, ConceptStatus.PUBLISHED);

        return concepts.stream()
                .map(c -> ConceptPreviewDTO.builder()
                        .id(c.getId())
                        .title(c.getTitle())
                        .difficulty(c.getDifficulty())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public void publishConcept(String id) {

        Concept concept = conceptRepository.findById(id)
                .orElseThrow(() -> new ConceptNotFoundException("Concept not found"));
        if (concept.getStatus() == ConceptStatus.PUBLISHED) {
            return;
        }

        concept.setStatus(ConceptStatus.PUBLISHED);

        conceptRepository.save(concept);
    }

}
