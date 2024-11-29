package com.example.warranty_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "User-Service", url = "http://localhost:8080")
public interface UserManagementClient {

    @GetMapping("/api/v1/user/validate")
    boolean validateToken(@RequestHeader("Authorization") String token);
}
