package com.example.demo.service;

import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    List<UserAccount> getAllUsers();

    UserAccount getUserById(Long id);

    UserAccount saveUser(UserAccount user);

    // ✅ REQUIRED
    void deactivateUser(Long id);
}
