package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "SAMPLE_DETAILS")
public class SampleDetails {

    @Id
    @Column(name = "SAMPLE_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String sampleIdentifier;

    @Column(name = "SAMPLE_TYPE")
    private String sampleType;

    @Column(name = "SAMPLE_CATEGORY")
    private String sampleCategory;

    @Column(name = "SAMPLE_DESCRIPTION")
    private String sampleDescription;

    @Column(name = "SAMPLE_RECEIVED_DATE")
    private String sampleReceivedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_IDENTIFIER")
    private CustomerDetails customerDetails; //FK

    @Column(name = "TEST_STATUS_CODE")
    private String testStatusCode;

    @Column(name = "TEST_ANALYSIS_START_DATE")
    private String testAnalysisStartDate;

    @Column(name = "TEST_ANALYSIS_END_DATE")
    private String testAnalysisEndDate;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_IDENTIFIER")
    private User user; //FK

    @Column(name = "CROP_DETAILS")
    private String cropDetails;

    @Column(name = "SAMPLE_LOCATION")
    private String sampleLocation;

    @Column(name = "SAMPLE_STATE_CODE")
    private String sampleStateCode;

    @Column(name = "SAMPLE_CITY")
    private String sampleCity;

    @Column(name = "SAMPLE_PINCODE")
    private String samplePineCode;

    @Column(name = "SAMPLE_PAYMENT_STATUS_CODE")
    private String samplePaymentStatusCode;
}
