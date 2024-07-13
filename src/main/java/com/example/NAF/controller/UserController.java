package com.example.NAF.controller;


import com.example.NAF.dao.CustomerDetailRepository;
import com.example.NAF.dao.SampleDetailRepository;
import com.example.NAF.services.JwtTokenService;
import com.example.NAF.utils.CustomerDetailVO;
import com.example.NAF.utils.SampleDetailVO;
import com.example.NAF.utils.UserTokenVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
@RequestMapping("/customer")
public class UserController {

    @Autowired
    private JwtTokenService jwtTokenService;

    @Autowired
    private CustomerDetailRepository customerDetailRepository;

    @Autowired
    private SampleDetailRepository sampleDetailRepository;

    @PostMapping("/add-customer")
    public ResponseEntity<String> addCustomer(@RequestBody CustomerDetailVO customerDetailVO,@RequestHeader("token") String token){

        UserTokenVO userTokenVO =null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("User is Unauthorized",HttpStatus.UNAUTHORIZED);
        }
        try{
            if(userTokenVO == null){
                return new ResponseEntity<>("User is Unauthorized",HttpStatus.UNAUTHORIZED);
            }
            customerDetailRepository.insertCustomerDetails(customerDetailVO.getCustomerIdentifier(), customerDetailVO.getFirstName(), customerDetailVO.getLastName(), customerDetailVO.getPhoneNumber()
            , customerDetailVO.getEmail(), customerDetailVO.getAddressLineOne(),customerDetailVO.getAddressLineTwo(),customerDetailVO.getCity(),customerDetailVO.getStateCode(), customerDetailVO.getPinCode());
            return new ResponseEntity<>("Customer added Successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Customer is not added", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping("/add-sample-details")
    public ResponseEntity<String> addSampleDetails(@RequestBody SampleDetailVO sampleDetailVO,@RequestHeader("token") String token){
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("User is Unauthorized",HttpStatus.UNAUTHORIZED);
        }
        try{

            if(userTokenVO == null){
                return new ResponseEntity<>("User is Unauthorized",HttpStatus.UNAUTHORIZED);
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate startDate = LocalDate.parse(sampleDetailVO.getTestAnalysisStartDate(), formatter);
            LocalDate endDate = LocalDate.parse(sampleDetailVO.getTestAnalysisEndDate(), formatter);
            sampleDetailRepository.insertSampleDetails(
                    sampleDetailVO.getSampleType(),
                    sampleDetailVO.getSampleIdentifier(),
                    sampleDetailVO.getSampleCategory(),
                    sampleDetailVO.getSampleDescription(),
                    sampleDetailVO.getSampleReceivedDate(),
                    sampleDetailVO.getCustomerDetails(),
                    sampleDetailVO.getTestStatusCode(),
                    startDate,
                    endDate,
                    sampleDetailVO.getUser(),
                    sampleDetailVO.getCropDetails(),
                    sampleDetailVO.getSampleLocation(),
                    sampleDetailVO.getSampleStateCode(),
                    sampleDetailVO.getSampleCity(),
                    sampleDetailVO.getSamplePineCode(),
                    sampleDetailVO.getSamplePaymentStatusCode()
            );

            return new ResponseEntity<>("Sample Details added successfully",HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("Sample Details request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
