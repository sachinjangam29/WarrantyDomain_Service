package com.example.warranty_service.client;

import io.jsonwebtoken.Claims;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "User-Service", url = "http://localhost:8080")
public interface UserManagementClient {

    @PostMapping("/api/user/validate")
    boolean validateToken(@RequestHeader("Authorization") String token);
}
