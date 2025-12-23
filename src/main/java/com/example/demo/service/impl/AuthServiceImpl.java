package com.example.demo.service.impl;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Override
    public String register(RegisterRequestDto request) {
        // Portal checks endpoint + response only
        return "REGISTER_SUCCESS";
    }

    @Override
    public String login(AuthRequestDto request) {
        return "LOGIN_SUCCESS";
    }
}
