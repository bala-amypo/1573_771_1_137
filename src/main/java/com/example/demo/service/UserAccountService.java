package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import java.util.List;

public interface UserAccountService {
    UserAccount create(UserAccount user);
    List<UserAccount> getAll();
    UserAccount update(Long id, UserAccount user);
}
