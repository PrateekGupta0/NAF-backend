package com.example.NAF.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name ="USER_ROLE")
@Data
public class UserRole {

    @Id
    @Column(name="USER_ROLE_CODE",length = 50, nullable = false, unique = true)
    private String userRoleCode;

    @Column(name = "USER_TASK_SEQ_NUMBER")
    private String userTaskSeqNumber;

    @Column(name="USER_ROLE_DESCRIPTION")
    private  String userRoleDescription;

    @Column(name="USER_TASK")
    private String userTask;

    @Column(name = "ACTIVE_INDICATOR")
    private Boolean activeIndicator;

}
