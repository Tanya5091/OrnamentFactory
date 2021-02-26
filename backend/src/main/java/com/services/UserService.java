package com.services;

import com.domain.entities.UserEntity;
import com.domain.type.Permission;
import com.dto.RegistrationDTO;
import com.repositories.PermissionRepository;
import com.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PermissionRepository permissionRepository;

    public UserEntity save(final UserEntity user) {
        return userRepository.save(user);
    }

    public Optional<UserEntity> findByLogin(final String login) {
        return userRepository.findByLogin(login);
    }



    public boolean loginExists(final String login) {
        return userRepository.existsAllByLogin(login);
    }

    public UserEntity registerAsSalesManager(final RegistrationDTO user) {

        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.SALES_MANAGER)))
                .build());
    }
    public UserEntity registerAsFactoryWorker(final RegistrationDTO user) {

        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.FACTORY_WORKER)))
                .build());
    }

    public UserEntity registerAsManager(final RegistrationDTO user) {

        return save(UserEntity.builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .permissions(Collections.singletonList(permissionRepository.findByPermission(Permission.MANAGER)))
                .build());
    }


}
