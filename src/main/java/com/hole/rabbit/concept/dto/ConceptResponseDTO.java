package com.hole.rabbit.concept.dto;


import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ConceptResponseDTO {

    private String id;
    private String title;
    private String coreInsight;
    private String whyItMatters;
    private Integer difficulty;

    private String provocativeQuestion;

    private List<ConceptPreviewDTO> deeper;
    private List<ConceptPreviewDTO> wider;
    private List<ConceptPreviewDTO> origin;
    private List<ConceptPreviewDTO> failure;
}
