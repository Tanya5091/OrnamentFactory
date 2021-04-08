package com.controllers;

import com.domain.entities.OrderEntity;
import com.domain.entities.UserEntity;
import com.domain.type.OrderStatus;
import com.dto.OrderDTO;
import com.services.OrderService;
import com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class AssignController {
    private final UserService userService;
    private final OrderService orderService;

    @PostMapping("/api/v1/addUserOrder/{userid}/{orderid}")
    public ResponseEntity addUserOrder(@PathVariable int userid, @PathVariable int orderid) {
        Optional<OrderEntity> orderEntity = orderService.findOrderById(orderid);
        if (orderEntity.isPresent()) {
            OrderEntity o = orderEntity.get();
            o.setStatus(OrderStatus.ACTIVE);
            userService.addOrder(o, userid);
//            Optional<UserEntity> userEntity = userService.findById(userid);
//            if (userEntity.isPresent()) {
//                orderService.addUser(orderid, userEntity.get());
            return new ResponseEntity(HttpStatus.ACCEPTED);
//            } else {
//                return new ResponseEntity(HttpStatus.BAD_REQUEST);
//            }
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("api/v1/unassignOrder/{userid}/{orderid}")
    public ResponseEntity unassignOrder(@PathVariable int userid, @PathVariable int orderid){
        Optional<OrderEntity> orderEntity = orderService.findOrderById(orderid);
        if (orderEntity.isPresent()) {
            OrderEntity o = orderEntity.get();
            o.setStatus(OrderStatus.NEW);
            userService.removeOrder(o, userid);
            return new ResponseEntity(HttpStatus.ACCEPTED);
        }
        else{
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("api/v1/create_order")
    public ResponseEntity create( @RequestBody final OrderDTO orderDTO ){
        UserEntity u = userService.findById(orderDTO.getSalesID()).get();
        orderService.createOrder(orderDTO, u);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
