package com.example.NAF.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SAMPLE_TEST_RESULT")
public class SampleTestResult {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SAMPLE_IDENTIFIER")
    private SampleDetails sampleDetails;//FK

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({
            @JoinColumn(name = "PARAMETER_GROUP", referencedColumnName = "PARAMETER_GROUP"),
            @JoinColumn(name = "PARAMETER_CODE", referencedColumnName = "PARAMETER_CODE")
    })
    private TestParameter testParameter;//FK

    @Id
    @Column(name = "TEST_RESULT_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String testResultIdentifier;

    @Column(name = "LAB_IDENTIFIER")
    private String labIdentifier;

    @Column(name="PARAMETER_RESULT_VALUE")
    private String parameterResultValue;



}
