package com.example.NAF.dao;

import com.example.NAF.model.UserRole;
import com.example.NAF.model.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_ROLE (USER_ROLE_CODE, USER_TASK_SEQ_NUMBER,USER_ROLE_DESCRIPTION,USER_TASK) VALUES (:userRoleCode,:userTaskSeq,:userRoleDescription,:userTask)", nativeQuery = true)
    public void insertUserRole(@Param("userRoleCode") String userRoleCode, @Param("userTaskSeq") String userTaskSeq, @Param("userRoleDescription") String userRoleDescription, @Param("userTask") String userTask);


    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_ROLE SET USER_TASK_SEQ_NUMBER = :userTaskSeq, USER_ROLE_DESCRIPTION = :userRoleDescription, USER_TASK = :userTask WHERE USER_ROLE_CODE = :userRoleCode", nativeQuery = true)
    public void updateUserRole(@Param("userRoleCode") String userRoleCode, @Param("userTaskSeq") String userTaskSeq, @Param("userRoleDescription") String userRoleDescription, @Param("userTask") String userTask);


}
