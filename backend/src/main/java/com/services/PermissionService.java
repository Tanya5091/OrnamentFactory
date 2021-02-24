package com.services;

import com.domain.entities.PermissionEntity;
import com.domain.type.Permission;
import com.repositories.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PermissionService {

    private final PermissionRepository permissionRepository;

    @Transactional
    public PermissionEntity saveSalesManagerPermission() {
        return permissionRepository.save(PermissionEntity.builder().permission(Permission.SALES_MANAGER).build());
    }
    @Transactional
    public PermissionEntity saveFactoryWorkerPermission() {
        return permissionRepository.save(PermissionEntity.builder().permission(Permission.FACTORY_WORKER).build());
    }

    @Transactional
    public PermissionEntity saveManagerPermission() {
        return permissionRepository.save(PermissionEntity.builder().permission(Permission.MANAGER).build());
    }
}
