package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class FertilizerRecommendedId {

    @Column(name = "FERTILIZER_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String fertilizerIdentifier;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RECOMMENDATION_CATEGORY_CODE")
    private RecommendationCategory recommendationCategory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "PARAMETER_GROUP", referencedColumnName = "PARAMETER_GROUP"),
            @JoinColumn(name = "PARAMETER_CODE", referencedColumnName = "PARAMETER_CODE")
    })
    private TestParameter testParameter;//FK
}
