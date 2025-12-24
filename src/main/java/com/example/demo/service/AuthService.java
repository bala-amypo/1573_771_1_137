package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;

public interface AuthService {

    // ✅ TESTS EXPECT STRING TOKEN
    String login(AuthRequestDto request);
}
