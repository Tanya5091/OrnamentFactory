package com.services;


import com.domain.entities.OrderEntity;
import com.domain.type.OrderStatus;
import com.dto.OrderDTO;
import com.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private OrderRepository orderRepository;

    //    public OrderEntity save(final OrderEntity order){
//        return orderRepository.save(order);
//    }
    public Optional<OrderEntity> findOrderById(final int id){
        return orderRepository.findById(id);
    }

    public boolean existById(final int id){
        return orderRepository.existsById(id);
    }

    public void deleteOrder(final int id){
        if(existById(id)){
            orderRepository.deleteById(id);
        }
        else{

        }
        //TODO
    }

//    public void changeStatus(int id, OrderStatus status){
//        orderRepository.setOrderStatus(id, status);
//    }


    public OrderEntity createOrder(final OrderDTO orderDTO){
        return orderRepository.save(OrderEntity.builder()
                .toyName(orderDTO.getToyName())
                .quantity(orderDTO.getQuantity())
                .priority(orderDTO.getPriority())
                .deadline(orderDTO.getDeadline())
                .status(OrderStatus.ACTIVE)
                .build());
    }

    public void changePriority(final OrderEntity orderEntity){
        //TODO
    }


}
