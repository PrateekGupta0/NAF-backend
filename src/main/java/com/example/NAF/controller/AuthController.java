package com.example.NAF.controller;

import com.example.NAF.dao.UserRepository;
import com.example.NAF.dao.UserRoleMappingRepository;
import com.example.NAF.dao.UserRoleRepository;
import com.example.NAF.model.User;
import com.example.NAF.model.UserRoleMapping;
import com.example.NAF.services.JwtTokenService;
import com.example.NAF.utils.UserLoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

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

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody UserLoginVO userLoginVO) {

        try{
            System.out.println(userLoginVO.getUsername()+" "+userLoginVO.getPassword());
            User loginDetailDb=userRepository.findByEmail(userLoginVO.getUsername());
            List<UserRoleMapping> userRoleDetails=userRoleMappingRepository.findByUserIdentifier(loginDetailDb.getUserIdentifier());
            String token = jwtTokenService.generateToken(userLoginVO.getUsername(), userRoleDetails.get(0).getUserRoleMappingId().getUserRole().getUserRoleCode());
            HashMap<String,Object> res=new HashMap<String,Object>();
            res.put("token",token);
            res.put("username",loginDetailDb.getEmail());
            res.put("role", userRoleDetails.get(0).getUserRoleMappingId().getUserRole().getUserRoleCode());
            res.put("message", "SUCCESS");
            return new ResponseEntity<>(res, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            HashMap<String,Object> res=new HashMap<String,Object>();
            res.put("token",null);
            res.put("userName",null);
            res.put("roleCode",null);
            res.put("message","FAILED");
            return new ResponseEntity<>(res,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
