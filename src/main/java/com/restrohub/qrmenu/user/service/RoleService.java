package com.restrohub.qrmenu.user.service;

import com.restrohub.qrmenu.user.dto.RoleRequest;
import com.restrohub.qrmenu.user.dto.RoleResponse;

import java.util.List;

public interface RoleService {

    // Create new role
    RoleResponse createRole(RoleRequest request);

    // Get role by ID
    RoleResponse getRoleById(Long id);

    // Get role by name
    RoleResponse getRoleByName(String name);

    // Get all roles
    List<RoleResponse> getAllRoles();

    // Get all active roles
    List<RoleResponse> getAllActiveRoles();

    // Update role
    RoleResponse updateRole(Long id, RoleRequest request);

    // Delete role
    void deleteRole(Long id);

    // Toggle role status
    RoleResponse toggleRoleStatus(Long id);

    // Check if role exists by name
    boolean existsByName(String name);
}