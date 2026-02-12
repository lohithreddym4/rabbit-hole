package com.hole.rabbit.traversal.service;


import com.hole.rabbit.concept.dto.ConceptPreviewDTO;
import com.hole.rabbit.concept.model.LinkType;

import java.util.List;

public interface TraversalService {

    List<ConceptPreviewDTO> traverse(String conceptId, LinkType type);
}
