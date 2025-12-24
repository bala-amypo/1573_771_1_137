package com.example.demo.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "test-secret-key";
    private static final long EXPIRATION = 3600000;

    public JwtUtil() {
    }

    /* ===== REQUIRED BY TESTS ===== */
    public String generateToken(String username) {
        return generateToken(new HashMap<>(), username);
    }

    /* ===== REQUIRED BY SERVICES ===== */
    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /* ===== REQUIRED BY TESTS ===== */
    public String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    /* ===== REQUIRED BY FILTER ===== */
    public String getUsername(String token) {
        return extractUsername(token);
    }

    public Claims getClaims(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username)
                && getClaims(token).getExpiration().after(new Date());
    }

    public long getExpirationMillis() {
        return EXPIRATION;
    }
}
