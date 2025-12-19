package com.example.demo.service;

import com.example.demo.entity.RolePermission;
import java.util.List;

public interface RolePermissionService {
    RolePermission grantPermission(RolePermission mapping);
    List<RolePermission> getPermissionsForRole(long roleId);
    RolePermission getMappingById(long id);
    void revokePermission(long mappingId);
}
