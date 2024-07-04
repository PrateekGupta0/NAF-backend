package com.example.NAF.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NafController {

    @GetMapping(value = "/health")
    public String health(){
        return "Server up and running";
    }
}
