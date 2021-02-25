package com.controllers;

import com.dto.OrderDTO;
import com.services.OrderService;
import com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("api/v1/create_order")
    public ResponseEntity create(final OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }


}
