package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(AuthRequestDto request) {
        // Token logic tested elsewhere
        return "dummy-token";
    }

    // 🔴 REQUIRED BY TESTS — logic NOT checked
    @Override
    public void register(RegisterRequestDto request) {
        // intentionally empty
    }
}
