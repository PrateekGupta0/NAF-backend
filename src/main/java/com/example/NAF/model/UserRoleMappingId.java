package com.example.NAF.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Embeddable
public class UserRoleMappingId {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_IDENTIFIER")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ROLE_CODE")
    private UserRole userRole;
}
