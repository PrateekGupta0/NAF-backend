package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TEST_PARAMETER_RANGE")
public class TestParameterRange {

    @EmbeddedId
    private TestParameterRangeId testParameterRangeId;

    @Column(name = "LOWER_VALUE")
    private String lowerValue;

    @Column(name = "HIGHER_VALUE")
    private String higherValue;

}
