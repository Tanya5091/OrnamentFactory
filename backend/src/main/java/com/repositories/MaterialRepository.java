package com.repositories;

import com.domain.entities.MaterialEntity;
import com.domain.type.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface MaterialRepository extends JpaRepository<MaterialEntity, Integer> {

    @Modifying
    @Transactional
    @Query("UPDATE MaterialEntity o set o.quantity = :quantity where o.id = :id")
    void setQuantity(@Param("id")final int id, @Param("quantity")final int quantity);
}
