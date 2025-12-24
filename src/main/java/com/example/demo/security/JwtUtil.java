package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // 🔴 EXACT SIGNATURE REQUIRED
    public String generateToken(UserDetails userDetails) {
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "dummy";
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        return true;
    }
}
