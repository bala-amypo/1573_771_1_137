package com.example.demo.service;

import com.example.demo.entity.UserRole;
import java.util.List;

public interface UserRoleService {

    UserRole assignRoleToUser(UserRole userRole);

    UserRole getUserRoleById(long id);

    List<UserRole> getRolesByUserId(long userId);

    List<UserRole> getUsersByRoleId(long roleId);

    UserRole updateUserRole(long id, UserRole userRole);

    void removeRoleFromUser(long id);
}
