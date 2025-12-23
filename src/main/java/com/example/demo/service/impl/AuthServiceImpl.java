package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public String login(AuthRequestDto request) {

        // 🔴 REQUIRED: AuthenticationManager MUST return Authentication
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        // 🔴 REQUIRED: get UserDetails from Authentication
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // 🔴 REQUIRED: return TOKEN STRING
        return jwtUtil.generateToken(userDetails);
    }
}