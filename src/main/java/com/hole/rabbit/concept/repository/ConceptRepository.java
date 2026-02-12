package com.hole.rabbit.concept.repository;


import com.hole.rabbit.concept.model.Concept;
import com.hole.rabbit.concept.model.ConceptStatus;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ConceptRepository extends MongoRepository<Concept, String> {

    Optional<Concept> findByIdAndStatus(String id, ConceptStatus status);

    List<Concept> findByIdInAndStatus(List<String> ids, ConceptStatus status);
}
