package com.repositories;

import com.domain.entities.PermissionEntity;
import com.domain.type.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Integer> {
    PermissionEntity findByPermission(Permission permission);
}
