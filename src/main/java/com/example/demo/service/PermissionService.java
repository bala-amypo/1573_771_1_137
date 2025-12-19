package com.example.demo.service;


import com.example.demo.entity.Permission;
import java.util.List;


public interface PermissionService {
Permission createPermission(Permission permission);
Permission updatePermission(long id, Permission permission);
Permission getPermissionById(long id);
List<Permission> getAllPermissions();
void deactivatePermission(long id);
}