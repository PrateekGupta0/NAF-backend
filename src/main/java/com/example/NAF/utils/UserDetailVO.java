package com.example.NAF.utils;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetailVO {

    private String userIdentifier;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private Boolean activeIndicator;
    private String userRoleCode;

}
