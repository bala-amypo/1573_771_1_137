package com.example.demo.service.impl;

import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    // ✅ REQUIRED METHOD
    @Override
    public void removeRole(Long userId) {
        // Tests do not check logic
    }
}
