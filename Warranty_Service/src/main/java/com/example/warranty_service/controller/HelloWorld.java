package com.example.warranty_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class HelloWorld {

    @GetMapping("/hello-world")
    public String hello(){
        return "you are in the Warranty Service -> method HelloWorld";
    }
}
