package com.example.NAF.dao;

import com.example.NAF.model.SampleDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;


@Repository
public interface SampleDetailRepository extends JpaRepository<SampleDetails,Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO SAMPLE_DETAILS (SAMPLE_IDENTIFIER, SAMPLE_TYPE, SAMPLE_CATEGORY, SAMPLE_DESCRIPTION, SAMPLE_RECEIVED_DATE, CUSTOMER_IDENTIFIER, TEST_STATUS_CODE, TEST_ANALYSIS_START_DATE, TEST_ANALYSIS_END_DATE, USER_IDENTIFIER, CROP_DETAILS, SAMPLE_LOCATION, SAMPLE_STATE_CODE, SAMPLE_CITY, SAMPLE_PINCODE, SAMPLE_PAYMENT_STATUS_CODE) " +
            "VALUES (:sampleIdentifier, :sampleType, :sampleCategory, :sampleDescription, :sampleReceivedDate, :customerIdentifier, :testStatusCode, :testAnalysisStartDate, :testAnalysisEndDate, :userIdentifier, :cropDetails, :sampleLocation, :sampleStateCode, :sampleCity, :samplePineCode, :samplePaymentStatusCode)", nativeQuery = true)
    void insertSampleDetails(@Param("sampleIdentifier") String sampleIdentifier,
                             @Param("sampleType") String sampleType,
                             @Param("sampleCategory") String sampleCategory,
                             @Param("sampleDescription") String sampleDescription,
                             @Param("sampleReceivedDate") String sampleReceivedDate,
                             @Param("customerIdentifier") String customerIdentifier,
                             @Param("testStatusCode") String testStatusCode,
                             @Param("testAnalysisStartDate") LocalDate testAnalysisStartDate,
                             @Param("testAnalysisEndDate") LocalDate testAnalysisEndDate,
                             @Param("userIdentifier") String userIdentifier,
                             @Param("cropDetails") String cropDetails,
                             @Param("sampleLocation") String sampleLocation,
                             @Param("sampleStateCode") String sampleStateCode,
                             @Param("sampleCity") String sampleCity,
                             @Param("samplePineCode") String samplePineCode,
                             @Param("samplePaymentStatusCode") String samplePaymentStatusCode);

}
