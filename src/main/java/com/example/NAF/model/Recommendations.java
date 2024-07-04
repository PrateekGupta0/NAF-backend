package com.example.NAF.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "RECOMMENDATION")
public class Recommendations {

    @EmbeddedId
    private RecommandationId recommandationId;

    @Column(name="FERTILIZER_QUANTITY")
    private int fertilizerQuantity;

    @Column(name = "FERTLIZER_APPLICATION_UNIT")
    private String fertilizerApplicationUnit;

    @Column(name = "FERTILIZER_APPLICATION_REMARKS")
    private String fertilizerApplicationRemarks;

    @Column(name = "TEST_PARAMETER_STATUS")
    private String testParameterStatus;
}
