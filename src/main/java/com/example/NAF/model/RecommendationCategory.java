package com.example.NAF.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "RECOMMENDATION_CATEGORY")
public class RecommendationCategory {

    @Id
    @Column(name = "RECOMMENDATION_CATEGORY_CODE",length = 50, nullable = false, unique = true)
    private String recommendationCategoryCode;

    @Column(name = "CATEGORY_TEXT")
    private String categoryText;
}
