package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;

public interface AuthService {

    // 🔴 MUST return String (JWT token)
    String login(AuthRequestDto request);
}