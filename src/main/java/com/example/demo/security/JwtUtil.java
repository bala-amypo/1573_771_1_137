package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtil {

    private final String SECRET = "MySuperSecretKeyForJwtGeneration123456";
    private final long EXPIRATION = 3600000; // 1 hour

    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public long getExpirationMillis() {
        return EXPIRATION;
    }

    public boolean isTokenValid(String token, String username) {
        try {
            return getUsername(token).equals(username)
                    && getClaims(token).getExpiration().after(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
