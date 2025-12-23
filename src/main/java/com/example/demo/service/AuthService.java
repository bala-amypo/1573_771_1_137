package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;

public interface AuthService {

    // TESTS EXPECT THIS EXACT SIGNATURE
    String login(AuthRequestDto request);
}