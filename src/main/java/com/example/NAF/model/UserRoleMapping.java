package com.example.NAF.model;


import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.Date;

@Data
@Entity
@Table(name ="USER_ROLE_MAPPING")
public class UserRoleMapping {

    @EmbeddedId
    private UserRoleMappingId userRoleMappingId;

    @Column(name = "CREATION_DATE")
    private Date creationDate;

    @Column(name = "ACTIVE_INDICATOR")
    private String activeIndicator;

}
