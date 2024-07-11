package com.example.NAF.controller;


import com.example.NAF.dao.UserRepository;
import com.example.NAF.dao.UserRoleMappingRepository;
import com.example.NAF.dao.UserRoleRepository;
import com.example.NAF.model.User;
import com.example.NAF.services.JwtTokenService;
import com.example.NAF.utils.RoleCodeVO;
import com.example.NAF.utils.UserDetailVO;
import com.example.NAF.utils.UserSearchDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
public class NafController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleMappingRepository userRoleMappingRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;



    @GetMapping(value = "/health")
    public String health(){
        return "Server up and running";
    }

    @GetMapping(value = "/get-user-detail")
    public ResponseEntity<List<UserSearchDb[]>> userDetails(@RequestHeader("token") String token){
        String userId = jwtTokenService.parseToken(token);

        try{
            List<UserSearchDb[]> users=userRepository.findAllUsersWithRoleMappings();
            return new ResponseEntity<>(users,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String,String>> login(@RequestParam String username, @RequestParam String password) {

        //need to be implemented.
        String token = jwtTokenService.generateToken(username);
        return new ResponseEntity<>(new HashMap<>(),HttpStatus.OK);
    }

    @PostMapping(value="/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserDetailVO userDetailVO, @RequestHeader("token") String token){
        String userId = jwtTokenService.parseToken(token);
        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();

        try{
            //insert in "user" table
            userRepository.insertUser(userDetailVO.getUserIdentifier(),userDetailVO.getFirstName(),userDetailVO.getLastName(),userDetailVO.getEmail(),userDetailVO.getPassword(),userDetailVO.getActiveIndicator());

            //insert in "userRoleMapping" table
            userRoleMappingRepository.insertUserRoleMapping(userDetailVO.getUserIdentifier(),userDetailVO.getUserRoleCode(),dateString,userDetailVO.getActiveIndicator());
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User creation request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(value="/add-role-code")
    public ResponseEntity<String> addRoleCode(@RequestBody RoleCodeVO roleCodeVO, @RequestHeader("token") String token){
        String userId = jwtTokenService.parseToken(token);


        try{
            //insert in "USER_ROLE" table
            userRoleRepository.insertUserRole(roleCodeVO.getUserRoleCode(), roleCodeVO.getUserTaskSeq(),roleCodeVO.getUserRoleDescription(),roleCodeVO.getUserTask());
            return new ResponseEntity<>("User role created successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User role creation request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody UserDetailVO userDetailVO, @RequestHeader("token") String token){
        String userId = jwtTokenService.parseToken(token);
        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();

        try{
            //update in "user" table
            userRepository.updateUser(userDetailVO.getUserIdentifier(),userDetailVO.getFirstName(),userDetailVO.getLastName(),userDetailVO.getEmail(),userDetailVO.getPassword(),userDetailVO.getActiveIndicator());

            //update in "userRoleMapping" table
            userRoleMappingRepository.updateUserRoleMapping(userDetailVO.getUserIdentifier(),userDetailVO.getUserRoleCode(),dateString,userDetailVO.getActiveIndicator());
            return new ResponseEntity<>("User updated successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User update request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/update-role-code")
    public ResponseEntity<String> updateRoleCode(@RequestBody RoleCodeVO roleCodeVO, @RequestHeader("token") String token){
        String userId = jwtTokenService.parseToken(token);


        try{
            //update in "USER_ROLE" table
            userRoleRepository.updateUserRole(roleCodeVO.getUserRoleCode(), roleCodeVO.getUserTaskSeq(),roleCodeVO.getUserRoleDescription(),roleCodeVO.getUserTask());
            return new ResponseEntity<>("User role updated successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User role update request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
