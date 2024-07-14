package com.example.NAF.controller;


import com.example.NAF.dao.UserRepository;
import com.example.NAF.dao.UserRoleMappingRepository;
import com.example.NAF.dao.UserRoleRepository;
import com.example.NAF.services.JwtTokenService;
import com.example.NAF.utils.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private JwtTokenService jwtTokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleMappingRepository userRoleMappingRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @GetMapping(value = "/get-user-detail")
    public ResponseEntity<List<UserResponseDetails>> userDetails(@RequestHeader("token") String token){
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
        }

        try{

            if(userTokenVO == null){
                return new ResponseEntity<>(null,HttpStatus.UNAUTHORIZED);
            }
            List<UserSearchDb> users=userRepository.findAllUsersWithRoleMappings();
            List<UserResponseDetails> res = new ArrayList<>();

            for (UserSearchDb userArray : users) {
                UserResponseDetails userDetailsArray = new UserResponseDetails();

                userDetailsArray = convertUser(userArray);

                res.add(userDetailsArray);
            }
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value="/add-user")
    public ResponseEntity<String> addUser(@RequestBody UserDetailVO userDetailVO, @RequestHeader("token") String token){
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }

        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();

        try{
            if(userTokenVO == null){
                return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
            }
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
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }

        try{
            if(userTokenVO == null){
                return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
            }
            //insert in "USER_ROLE" table
            userRoleRepository.insertUserRole(roleCodeVO.getUserRoleCode(), roleCodeVO.getUserTaskSeq(),roleCodeVO.getUserRoleDescription(),roleCodeVO.getUserTask());
            return new ResponseEntity<>("User role created successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User role creation request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping(value = "/role-codes")
    public ResponseEntity getRoleCodes(@RequestHeader("token") String token) {
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }

        try{
            if(userTokenVO == null){
                return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
            }
//            List<RoleCodeDb> roleCodeDbs = userRoleRepository.findAllUserRoles();
            return new ResponseEntity<>(userRoleRepository.findAllUserRoles(), HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User role fetch request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update-user")
    public ResponseEntity<String> updateUser(@RequestBody UserDetailVO userDetailVO, @RequestHeader("token") String token){
        UserTokenVO userTokenVO=null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }
        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();

        try{
            if(userTokenVO == null){
                return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
            }
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
        UserTokenVO userTokenVO =null ;
        try{
            userTokenVO = jwtTokenService.parseToken(token);
        }
        catch (Exception e){
            return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
        }


        try{

            if(userTokenVO == null){
                return new ResponseEntity<>("Unauthorized user",HttpStatus.UNAUTHORIZED);
            }
            //update in "USER_ROLE" table
            userRoleRepository.updateUserRole(roleCodeVO.getUserRoleCode(), roleCodeVO.getUserTaskSeq(),roleCodeVO.getUserRoleDescription(),roleCodeVO.getUserTask());
            return new ResponseEntity<>("User role updated successfully", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>("User role update request failed",HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    private UserResponseDetails convertUser(UserSearchDb user) {
        UserResponseDetails userDetails = new UserResponseDetails();
        userDetails.setUserIdentifier(user.getUserIdentifier());
        userDetails.setName(user.getFirstName() + " " + user.getLastName());
        userDetails.setEmail(user.getEmail());
        userDetails.setActiveIndicator(user.getActiveIndicator());
        userDetails.setCreationDate(user.getCreationDate());
        userDetails.setUserRole(user.getUserRole());
        return userDetails;
    }
}
