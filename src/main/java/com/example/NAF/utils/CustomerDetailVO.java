package com.example.NAF.utils;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CustomerDetailVO {


    private String customerIdentifier;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String addressLineOne;
    private String addressLineTwo;
    private String city;
    private String stateCode;
    private String pinCode;

}
