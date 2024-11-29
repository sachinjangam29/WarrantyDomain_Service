package com.example.warranty_service.filter;

import com.example.warranty_service.client.UserManagementClient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {
    private final UserManagementClient userManagementClient;

    @Autowired
    public JwtAuthFilter(UserManagementClient userManagementClient) {
        this.userManagementClient = userManagementClient;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            boolean isValidToken = userManagementClient.validateToken(token);
            if (isValidToken) {
                SecurityContextHolder.getContext().setAuthentication(
                        (Authentication) new WebAuthenticationDetailsSource().buildDetails(request)
                );
            }
        }
        filterChain.doFilter(request, response);
    }
}
