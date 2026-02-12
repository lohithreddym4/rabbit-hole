package com.hole.rabbit.concept.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConceptPreviewDTO {

    private String id;
    private String title;
    private Integer difficulty;
}
