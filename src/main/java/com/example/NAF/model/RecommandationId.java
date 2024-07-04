package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class RecommandationId {

    @Column(name = "SAMPLE_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String sampleIdentifier;

    @Column(name = "TEST_RESULT_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String testResultIdentifier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "PARAMETER_GROUP", referencedColumnName = "PARAMETER_GROUP"),
            @JoinColumn(name = "PARAMETER_CODE", referencedColumnName = "PARAMETER_CODE"),
            @JoinColumn(name = "FERTILIZER_IDENTIFIER", referencedColumnName = "FERTILIZER_IDENTIFIER"),
            @JoinColumn(name = "RECOMMENDATION_CATEGORY_CODE", referencedColumnName = "RECOMMENDATION_CATEGORY_CODE")
    })
    private FertilizersRecommended fertilizersRecommended;

}
