package com;

import com.services.PermissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class InitializingPermissionBean implements InitializingBean {

    private final PermissionService permissionService;

    @Override
    public void afterPropertiesSet() throws Exception {
//        permissionService.saveSalesManagerPermission();
//        permissionService.saveFactoryWorkerPermission();
//        permissionService.saveManagerPermission();
    }
}
