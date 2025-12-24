package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;

public interface AuthService {

    String login(AuthRequestDto request);

    // ✅ MUST be void (tests expect this)
    void register(RegisterRequestDto request);
}
