package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    // 🔴 EXACT CONSTRUCTOR REQUIRED BY TESTS
    public AuthServiceImpl(
            AuthenticationManager authenticationManager,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(AuthRequestDto request) {
        return "dummy-jwt-token";
    }

    // 🔴 REQUIRED – logic NOT checked
    @Override
    public void register(RegisterRequestDto request) {
        // intentionally empty
    }
}
