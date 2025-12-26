package com.example.demo.controller;

import com.example.demo.dto.AuthRequestDto;
import com.example.demo.dto.AuthResponseDto;
import com.example.demo.dto.RegisterRequestDto;
import com.example.demo.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public AuthResponseDto register(
            @RequestBody RegisterRequestDto dto) {
        return service.register(dto);
    }

    @PostMapping("/login")
    public AuthResponseDto login(
            @RequestBody AuthRequestDto dto) {
        return service.login(dto);
    }
}
