package com.example.NAF.utils;


import lombok.Data;

@Data
public class SampleDetailVO {
    private String sampleIdentifier;
    private String sampleType;
    private String sampleCategory;
    private String sampleDescription;
    private String sampleReceivedDate;
    private String customerDetails; //FK
    private String testStatusCode;
    private String testAnalysisStartDate;
    private String testAnalysisEndDate;
    private String user; //FK
    private String cropDetails;
    private String sampleLocation;
    private String sampleStateCode;
    private String sampleCity;
    private String samplePineCode;
    private String samplePaymentStatusCode;

}
