package com.hole.rabbit.concept.service;

import com.hole.rabbit.concept.dto.ConceptResponseDTO;
import com.hole.rabbit.concept.dto.CreateConceptDTO;
public interface ConceptService {

    ConceptResponseDTO getConceptById(String id);

    String createConcept(CreateConceptDTO dto);
    void publishConcept(String id);

}
