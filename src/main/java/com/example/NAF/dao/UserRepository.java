package com.example.NAF.dao;


import com.example.NAF.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO USER (USER_IDENTIFIER, FIRST_NAME,LAST_NAME,EMAIL,PASSWORD,ACTIVE_INDICATOR) VALUES (:userIdentifier, :firstName,:lastName,:email,:password,:activeIndicator)", nativeQuery = true)
    void insertUser(@Param("userIdentifier") String userIdentifier, @Param("firstName") String firstName,@Param("lastName") String lastName,@Param("email") String email,@Param("password") String password,@Param("activeIndicator") Boolean activeIndicator);

    @Modifying
    @Transactional
    @Query(value = "UPDATE USER SET FIRST_NAME = :firstName, LAST_NAME = :lastName, EMAIL = :email, PASSWORD = :password, ACTIVE_INDICATOR = :activeIndicator WHERE USER_IDENTIFIER = :userIdentifier", nativeQuery = true)
    public void updateUser(@Param("userIdentifier") String userIdentifier,
                           @Param("firstName") String firstName,
                           @Param("lastName") String lastName,
                           @Param("email") String email,
                           @Param("password") String password,
                           @Param("activeIndicator") Boolean activeIndicator);
}
