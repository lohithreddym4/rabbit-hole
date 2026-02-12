package com.hole.rabbit.traversal.service;

import com.hole.rabbit.concept.dto.ConceptPreviewDTO;
import com.hole.rabbit.concept.model.Concept;
import com.hole.rabbit.concept.model.ConceptStatus;
import com.hole.rabbit.concept.model.LinkType;
import com.hole.rabbit.concept.repository.ConceptRepository;
import com.hole.rabbit.exception.ConceptNotFoundException;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TraversalServiceImpl implements TraversalService {

    private final ConceptRepository conceptRepository;

    @Override
    public List<ConceptPreviewDTO> traverse(String conceptId, LinkType type) {

        Concept concept = conceptRepository
                .findByIdAndStatus(conceptId, ConceptStatus.PUBLISHED)
                .orElseThrow(() -> new ConceptNotFoundException("Concept not found"));

        List<String> nextIds = switch (type) {
            case DEEPER -> concept.getDeeper();
            case WIDER -> concept.getWider();
            case ORIGIN -> concept.getOrigin();
            case FAILURE -> concept.getFailure();
        };

        if (nextIds == null || nextIds.isEmpty()) {
            return List.of();
        }

        List<Concept> nextConcepts =
                conceptRepository.findByIdInAndStatus(nextIds, ConceptStatus.PUBLISHED);

        return nextConcepts.stream()
                .map(c -> ConceptPreviewDTO.builder()
                        .id(c.getId())
                        .title(c.getTitle())
                        .difficulty(c.getDifficulty())
                        .build())
                .collect(Collectors.toList());
    }
}
