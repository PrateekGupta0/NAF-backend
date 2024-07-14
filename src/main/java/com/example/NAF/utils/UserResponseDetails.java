package com.example.NAF.utils;


import lombok.Data;

import java.util.Date;

@Data
public class UserResponseDetails {

    private String userIdentifier;
    private String name;
    private String email;
    private Boolean activeIndicator;
    private Date creationDate;
    private String userRole;
}
