package com.example.NAF.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class Parameter implements Serializable {

    @Column(name = "PARAMETER_GROUP")
    private String parameterGroup;

    @Column(name = "PARAMETER_CODE")
    private String parameterCode;
}
