package com.hole.rabbit.concept.model;

import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "concepts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concept {

    @Id
    private String id;

    private String title;

    private String coreInsight;     // 1–2 lines. Mental hook.
    private String whyItMatters;    // Creates relevance.

    private Integer difficulty;     // 1–5 (Do NOT overthink scale)

    private Double gravityScore;    // Future recommendation engine

    private List<String> deeper;
    private List<String> wider;
    private List<String> origin;
    private List<String> failure;

    private String provocativeQuestion;

    private ConceptStatus status;   // IMPORTANT
}

