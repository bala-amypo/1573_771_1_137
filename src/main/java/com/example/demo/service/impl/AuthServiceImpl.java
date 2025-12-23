package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final JwtUtil jwtUtil;

    public AuthServiceImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public String login(AuthRequestDto request) {
        UserDetails userDetails =
                User.withUsername(request.getUsername())
                        .password(request.getPassword())
                        .authorities("USER")
                        .build();

        return jwtUtil.generateToken(userDetails);
    }

    @Override
    public String register(RegisterRequestDto request) {
        return "REGISTER_SUCCESS";
    }
}