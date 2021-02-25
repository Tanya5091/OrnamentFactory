package com.repositories;

import com.domain.entities.OrderEntity;
import com.domain.type.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT order FROM OrderEntity order "
            + "WHERE order.id = :id")
    Optional<OrderEntity> findById(@Param("id") int id);

//    @Modifying
//    @Query("delete from OrderEntity order where order.id=:id")
//    void deleteById(@Param("id") int id);

//    @Modifying
//    @Query("update OrderEntity order set order.status = ?2 where order.id = ?1")
//    void setOrderStatus(final int id, final OrderStatus status);

}
