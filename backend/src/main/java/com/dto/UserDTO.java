package com.dto;

import com.domain.entities.OrderEntity;
import com.domain.entities.PermissionEntity;
import com.domain.entities.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;
    private String login;
    private List<OrderDTO> orders;

    public UserDTO(UserEntity user) {
        id = user.getId();
        login = user.getLogin();
        orders = new ArrayList<>();
        for (OrderEntity o : user.getOrders()) {
            orders.add(new OrderDTO(o.getToyName(), o.getQuantity(), o.getPriority(), o.getDeadline(), o.getStatus().toString(), o.getId()));
        }
    }
}
