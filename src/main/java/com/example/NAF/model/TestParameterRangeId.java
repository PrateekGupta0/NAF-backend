package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Embeddable
public class TestParameterRangeId {


    @Column(name = "RANGE_TEXT",length = 50, nullable = false, unique = true)
    private String rangeText;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "PARAMETER_GROUP", referencedColumnName = "PARAMETER_GROUP"),
            @JoinColumn(name = "PARAMETER_CODE", referencedColumnName = "PARAMETER_CODE")
    })
    private TestParameter testParameter;//FK
}
