package com.example.demo.service.impl;

import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public boolean isUserActive(UserAccount user) {
        // ✅ Correct boolean getter
        return user.isActive();
    }
}
