package com.example.demo.service.impl;

import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import com.example.demo.dto.AuthRequestDto;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    // ===== DO NOT CHANGE =====
    public AuthServiceImpl(AuthenticationManager authenticationManager,
                           UserDetailsService userDetailsService,
                           JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(AuthRequestDto request) {
        return jwtUtil.generateToken(
                userDetailsService.loadUserByUsername(request.getUsername())
        );
    }
}
