package com.example.NAF.model;


import jakarta.persistence.*;

@Entity
@Table(name ="USER")
public class User {

    @Id
    @Column(name="USER_IDENTIFIER" ,length = 50, nullable = false, unique = true)
    private Integer userIdentifier;

    @Column(name="firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "active_Indicator")
    private String activeIndicator;
}
