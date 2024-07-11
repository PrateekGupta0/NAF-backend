package com.example.NAF.dao;

import com.example.NAF.model.UserRoleMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UserRoleMappingRepository extends JpaRepository<UserRoleMapping, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER_ROLE_MAPPING (USER_IDENTIFIER, USER_ROLE_CODE,CREATION_DATE,ACTIVE_INDICATOR) VALUES (:userIdentifier, :userRoleCode,:creationDate,:activeIndicator)", nativeQuery = true)
    public void insertUserRoleMapping(@Param("userIdentifier") String userIdentifier, @Param("userRoleCode") String userRoleCode, @Param("creationDate") String creationDate, @Param("activeIndicator") Boolean activeIndicator);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER_ROLE_MAPPING SET USER_ROLE_CODE = :userRoleCode, CREATION_DATE = :creationDate, ACTIVE_INDICATOR = :activeIndicator WHERE USER_IDENTIFIER = :userIdentifier", nativeQuery = true)
    public void updateUserRoleMapping(@Param("userIdentifier") String userIdentifier,
                                      @Param("userRoleCode") String userRoleCode,
                                      @Param("creationDate") String creationDate,
                                      @Param("activeIndicator") Boolean activeIndicator);
}
