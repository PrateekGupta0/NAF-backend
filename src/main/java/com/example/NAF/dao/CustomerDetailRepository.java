package com.example.NAF.dao;

import com.example.NAF.model.CustomerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface CustomerDetailRepository extends JpaRepository<CustomerDetails,Long> {


    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CUSTOMER_DETAILS (CUSTOMER_IDENTIFIER, FIRST_NAME, LAST_NAME, PHONE_NUMBER, EMAIL, ADDRESS_LINE_ONE, ADDRESS_LINE_TWO, CITY, STATE_CODE, PIN_CODE) " +
            "VALUES (:customerIdentifier, :firstName, :lastName, :phoneNumber, :email, :addressLineOne, :addressLineTwo, :city, :stateCode, :pinCode)", nativeQuery = true)
    void insertCustomerDetails(@Param("customerIdentifier") String customerIdentifier,
                               @Param("firstName") String firstName,
                               @Param("lastName") String lastName,
                               @Param("phoneNumber") String phoneNumber,
                               @Param("email") String email,
                               @Param("addressLineOne") String addressLineOne,
                               @Param("addressLineTwo") String addressLineTwo,
                               @Param("city") String city,
                               @Param("stateCode") String stateCode,
                               @Param("pinCode") String pinCode);
}
