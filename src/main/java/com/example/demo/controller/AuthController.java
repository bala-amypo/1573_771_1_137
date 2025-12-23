package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // LOGIN
    @PostMapping("/login")
    public ApiResponse<AuthResponseDto> login(@RequestBody AuthRequestDto request) {

        AuthResponseDto response = authService.login(request);
        return ApiResponse.success("Login successful", response);
    }

    // REGISTER
    @PostMapping("/register")
    public ApiResponse<String> register(@RequestBody RegisterRequestDto request) {

        String message = authService.register(request);
        return ApiResponse.success(message, message);
    }
}
