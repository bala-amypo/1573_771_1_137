package com.example.demo.dto;

public class AuthRequestDto {

    private String username;
    private String password;

    // 🔥 TESTS REQUIRE THIS EXACT METHOD
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
