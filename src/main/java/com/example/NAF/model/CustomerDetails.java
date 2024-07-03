package com.example.NAF.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CUSTOMER_DETAILS")
public class CustomerDetails {

    @Id
    @Column(name="CUSTOMER_IDENTIFIER",length = 50, nullable = false, unique = true)
    private String customerIdentifier;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "ADDRESS_LINE_ONE")
    private String addressLineOne;

    @Column(name = "ADDRESS_LINE_TWO")
    private String addressLineTwo;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE_CODE")
    private String stateCode;

    @Column(name = "PINCODE")
    private String pinCode;

}
