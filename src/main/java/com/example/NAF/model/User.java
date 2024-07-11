package com.example.NAF.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="USER")
@Data
public class User {

    @Id
    @Column(name="USER_IDENTIFIER" ,length = 50, nullable = false, unique = true)
    private String userIdentifier;

    @Column(name="FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ACTIVE_INDICATOR")
    private Boolean activeIndicator;
}
