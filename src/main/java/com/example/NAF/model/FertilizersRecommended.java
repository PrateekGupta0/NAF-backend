package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FERTILIZER_RECOMMENDED")
public class FertilizersRecommended {

    @EmbeddedId
    private FertilizerRecommendedId fertilizerRecommendedId;

    @Column(name = "FERTILIZER_NAME")
    private String fertilizerName;
}
