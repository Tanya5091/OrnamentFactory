package com.domain.entities;


import com.domain.type.OrderStatus;
import com.domain.type.Priority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ordertable")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderEntity {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "toyName")
    private String toyName;

    @Column(name = "quantity")
    private int quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @Column(name = "deadline")
    private Date deadline;

//    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatus status;

    public String getToyName() {
        return toyName;
    }

    public int getQuantity() {
        return quantity;
    }

    public Priority getPriority() {
        return priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public OrderStatus getStatus() {
        return status;
    }

//    public Integer getId() {
//        return id;
//    }


    @ManyToOne
    @JoinTable(
            name = "ordertable_to_user",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserEntity user;
    @ManyToOne
    @JoinTable(
            name = "ordertable_to_sales",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private UserEntity sales;
}
