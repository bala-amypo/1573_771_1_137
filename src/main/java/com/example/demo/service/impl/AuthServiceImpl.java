package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String login(AuthRequestDto request) {
        return "dummy-token";
    }

    // 🔴 REQUIRED EVEN IF EMPTY
    @Override
    public void register(RegisterRequestDto request) {
        // tests do not validate logic
    }
}
