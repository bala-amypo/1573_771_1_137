package com.example.demo.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // existing methods (DO NOT REMOVE)
    public String generateToken(UserDetails userDetails) {
        // existing implementation
        return null;
    }

    public String extractUsername(String token) {
        // existing implementation
        return null;
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        // existing implementation
        return true;
    }

    // ✅ ADD THIS METHOD EXACTLY
    public String getUsername(String token) {
        return extractUsername(token);
    }
}
