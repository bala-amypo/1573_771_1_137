package com.example.demo.service;

import com.example.demo.entity.UserRole;
import java.util.List;

public interface UserRoleService {

    UserRole assignRoleToUser(UserRole userRole);

    UserRole getUserRoleById(Long id);

    List<UserRole> getRolesByUserId(Long userId);

    List<UserRole> getUsersByRoleId(Long roleId);

    void removeRoleFromUser(Long id);
}
