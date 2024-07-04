package com.example.NAF.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class Parameter implements Serializable {

    @Column(name = "PARAMETER_GROUP",length = 50, nullable = false, unique = true)
    private String parameterGroup;

    @Column(name = "PARAMETER_CODE",length = 50, nullable = false, unique = true)
    private String parameterCode;
}
