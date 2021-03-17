package com.services;


import com.domain.entities.OrderEntity;
import com.domain.type.OrderStatus;
import com.domain.type.Priority;
import com.dto.OrderDTO;
import com.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

        public OrderEntity save(final OrderEntity order){
        return orderRepository.save(order);
    }
    public Optional<OrderEntity> findOrderById(final int id){
        return orderRepository.findById(id);
    }

    public Optional<List<OrderEntity>> findOrderByName(final String name){
        return orderRepository.findByName(name);
    }

    public boolean existById(final int id){
        return orderRepository.existsById(id);
    }

    public HttpStatus deleteOrder(final int id){
        if(orderRepository.existsById(id)){
            orderRepository.deleteById(id);
            return HttpStatus.OK;
        }
        else{
            return HttpStatus.NOT_FOUND;
        }
    }

    public void changeStatus(String name, OrderStatus status){
        orderRepository.setOrderStatus(name, status);
    }

    public void changePriority(String name, Priority priority){
        orderRepository.setOrderPriority(name, priority);
    }

    public OrderEntity createOrder(final OrderDTO orderDTO){
        return save(OrderEntity.builder()
                .toyName(orderDTO.getToyName())
                .quantity(orderDTO.getQuantity())
                .priority(orderDTO.getPriority())
                .deadline(orderDTO.getDeadline())
                .status(OrderStatus.NEW)
                .build());
    }

//    public List<OrderEntity> getAllOrders(){
//            return orderRepository.getAllOrders();
//    }
    public List<OrderEntity> getAllOrders(){
            return orderRepository.findAll();
//            return orderRepository.getAllOrders();
    }



}
