package com.example.demo.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.util.*;
import java.security.Key;

public class JwtUtil {

    private final long EXPIRATION = 3600000;
    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public JwtUtil() {}

    public String generateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(key)
                .compact();
    }

    public String getUsername(String token) {
        return getClaims(token).getSubject();
    }

    public Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public long getExpirationMillis() {
        return EXPIRATION;
    }

    public boolean isTokenValid(String token, String username) {
        return getUsername(token).equals(username)
                && getClaims(token).getExpiration().after(new Date());
    }
}
