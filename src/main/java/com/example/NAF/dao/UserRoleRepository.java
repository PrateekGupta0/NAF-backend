package com.example.NAF.dao;

import com.example.NAF.model.UserRole;
import com.example.NAF.utils.RoleCodeDb;
import com.example.NAF.utils.RoleCodeVO;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_ROLE (USER_ROLE_CODE, USER_TASK_SEQ_NUMBER,USER_ROLE_DESCRIPTION,USER_TASK) VALUES (:userRoleCode,:userTaskSeq,:userRoleDescription,:userTask)", nativeQuery = true)
    void insertUserRole(String userRoleCode, String userTaskSeq, String userRoleDescription, String userTask);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_ROLE SET USER_TASK_SEQ_NUMBER = :userTaskSeq, USER_ROLE_DESCRIPTION = :userRoleDescription, USER_TASK = :userTask WHERE USER_ROLE_CODE = :userRoleCode", nativeQuery = true)
    void updateUserRole(String userRoleCode, String userTaskSeq, String userRoleDescription, String userTask);

    @Query("SELECT new com.example.NAF.utils.RoleCodeDb(u.userRoleCode, u.userTaskSeqNumber, u.userRoleDescription, u.userTask, u.activeIndicator) FROM UserRole u")
    List<RoleCodeDb> findAllUserRoles();
}