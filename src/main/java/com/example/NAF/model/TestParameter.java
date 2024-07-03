package com.example.NAF.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "TEST_PARAMETER")
public class TestParameter {

    @EmbeddedId
    private Parameter parameter;

    @Column(name = "PARAMETER_TEXT")
    private String parameterText;

    @Column(name = "PARAMETER_UNITS")
    private String parameterUnits;
}
