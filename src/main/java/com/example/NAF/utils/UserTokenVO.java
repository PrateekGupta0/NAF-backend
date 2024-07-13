package com.example.NAF.utils;

import lombok.Data;

@Data
public class UserTokenVO {
    private String userId;
    private String roleCode;

    public UserTokenVO(String userId, String roleCode) {
        this.userId = userId;
        this.roleCode = roleCode;
    }
}
