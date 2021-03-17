package com.repositories;

import com.domain.entities.OrderEntity;
import com.domain.type.OrderStatus;
import com.domain.type.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    @Query("SELECT order FROM OrderEntity order "
            + "WHERE order.id = :id")
    Optional<OrderEntity> findById(@Param("id") int id);

    @Query("SELECT order FROM OrderEntity order WHERE order.toyName = :name")
    Optional<List<OrderEntity>> findByName(@Param("name") String name);

    @Query("SELECT order FROM OrderEntity order")
    List<OrderEntity> findAll();

    @Modifying
    @Transactional
    @Query("delete from OrderEntity o where o.id=:id")
    void deleteById(@Param("id") int id);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o set o.status = :status where o.id = :id")
    void setOrderStatus(@Param("id")final int id, @Param("status")final OrderStatus status);

    @Modifying
    @Transactional
    @Query("UPDATE OrderEntity o set o.priority = :priority where o.id = :id")
    void setOrderPriority(@Param("id")final int id, @Param("priority")final Priority priority);

    @Query("SELECT order FROM OrderEntity order")
    List<OrderEntity> getAllOrders();


}
