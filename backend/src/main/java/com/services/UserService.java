package com.services;

import com.domain.entities.OrderEntity;
import com.domain.entities.UserEntity;
import com.domain.type.Permission;
import com.dto.LoginDTO;
import com.dto.RegistrationDTO;
import com.repositories.PermissionRepository;
import com.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
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

    public Optional<UserEntity> findById(final int id){return userRepository.findById(id);}

    public Optional<UserEntity> checkCredentials(final LoginDTO user) {
        return userRepository.checkCredentials(user.getLogin(), user.getPassword());
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
    @Transactional
    public void deleteUserByLogin(final String login){  userRepository.deleteUserEntityByLogin(login);}

    public List<OrderEntity> getUserOrders(int userId) {
        return userRepository.getUserOrders(userId);
    }
    public void addOrder(final OrderEntity order, final int id) {
        Optional<UserEntity> user = findById(id);
        if (user.isPresent()) {
            UserEntity us = user.get();
            List<OrderEntity> orders = getUserOrders(id);
            orders.add(order);
            us.setOrders(orders);
            save(us);
        }
    }

    public List<UserEntity> getUsers(){
        return userRepository.findAll();
    }

//    public List<OrderEntity> findUserOrders(int id) { return userRepository.findOrdersById(id);}
}
