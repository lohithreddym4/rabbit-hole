package com.hole.rabbit.concept.dto;


import lombok.Data;

import java.util.List;

@Data
public class CreateConceptDTO {

    private String title;
    private String coreInsight;
    private String whyItMatters;

    private Integer difficulty;

    private List<String> deeper;
    private List<String> wider;
    private List<String> origin;
    private List<String> failure;

    private String provocativeQuestion;
}
