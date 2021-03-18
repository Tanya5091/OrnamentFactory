package com.repositories;

import com.domain.entities.OrderEntity;
import com.domain.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query("SELECT user FROM UserEntity user "
            + "LEFT JOIN FETCH user.permissions "
            + "WHERE user.login = :login")
    Optional<UserEntity> findByLogin(@Param("login") String login);

    @Query("SELECT user FROM UserEntity user WHERE user.login = :login and user.password= :password")
    Optional<UserEntity> checkCredentials(@Param("login") String login, @Param("password") String password);

    boolean existsAllByLogin(final String login);

    void deleteUserEntityByLogin(final String login);

    @Query("SELECT orderEnt FROM OrderEntity orderEnt "
            + "JOIN orderEnt.user user "
            + "WHERE user.id = :id")
    List<OrderEntity> getUserOrders(@Param("id") int userId);

//    @Query("SELECT order FROM OrderEntity order "
//            + "JOIN order.user user "
//            + "WHERE user.id = :id")
//    List<OrderEntity> findOrdersById(@Param("id") int id);
}
