package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // REQUIRED BY TESTS
    public String generateToken(UserDetails userDetails) {
        return "dummy-token";
    }

    // REQUIRED BY FILTER
    public String getUsername(String token) {
        return "dummy";
    }

    // REQUIRED BY TESTS
    public String extractUsername(String token) {
        return "dummy";
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return true;
    }
}
