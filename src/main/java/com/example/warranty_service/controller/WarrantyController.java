package com.example.warranty_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/warranty")
public class WarrantyController {

    @PostMapping("/genius")
public String helloGenius(){
    return "Hello Genius! How are you?";
}
}
