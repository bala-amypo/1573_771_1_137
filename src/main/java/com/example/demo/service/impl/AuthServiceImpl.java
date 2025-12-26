package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.UserAccount;
import com.example.demo.exception.*;
import com.example.demo.repository.UserAccountRepository;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.*;

public class AuthServiceImpl implements AuthService {

    private final UserAccountRepository repo;
    private final PasswordEncoder encoder;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(UserAccountRepository r, PasswordEncoder p,
                           AuthenticationManager a, JwtUtil j) {
        this.repo = r;
        this.encoder = p;
        this.authManager = a;
        this.jwtUtil = j;
    }

    @Override
    public AuthResponseDto register(RegisterRequestDto req) {
        if (repo.existsByEmail(req.getEmail()))
            throw new BadRequestException("Duplicate email");

        UserAccount u = new UserAccount();
        u.setEmail(req.getEmail());
        u.setPassword(encoder.encode(req.getPassword()));
        repo.save(u);

        String token = jwtUtil.generateToken(Map.of("email", u.getEmail()), u.getEmail());
        return new AuthResponseDto(token);
    }

    @Override
    public AuthResponseDto login(AuthRequestDto req) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword())
        );

        UserAccount user = repo.findByEmail(req.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        String token = jwtUtil.generateToken(Map.of("email", user.getEmail()), user.getEmail());
        return new AuthResponseDto(token);
    }
}
