package com.example.demo.service;

import com.example.demo.dto.AuthRequestDto;

public interface AuthService {
    String login(AuthRequestDto request);
}
