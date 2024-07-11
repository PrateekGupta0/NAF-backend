package com.example.NAF.utils;


import lombok.Data;

import java.util.Date;

@Data
public class UserSearchDb {

    private String userIdentifier;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean activeIndicator;
    private Date creationDate;


    public UserSearchDb(String userIdentifier, String firstName, String lastName, String email, Boolean activeIndicator, Date creationDate) {
        this.userIdentifier = userIdentifier;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.activeIndicator = activeIndicator;
        this.creationDate = creationDate;
    }
}
