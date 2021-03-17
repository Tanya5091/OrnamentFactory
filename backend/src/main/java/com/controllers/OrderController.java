package com.controllers;

import com.domain.entities.OrderEntity;
import com.domain.type.ChangePriority;
import com.domain.type.ChangeStatus;
import com.domain.type.OrderStatus;
import com.domain.type.Priority;
import com.dto.OrderDTO;
import com.services.OrderService;
import com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("api/v1/create_order")
    public ResponseEntity create(@RequestBody final OrderDTO orderDTO){
        orderService.createOrder(orderDTO);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping("api/v1/change_status")
    public ResponseEntity changeStatus(@RequestBody ChangeStatus changeStatus){
        OrderStatus orderStatus = OrderStatus.values()[changeStatus.getStatus()];
        orderService.changeStatus(changeStatus.getName(), orderStatus);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @PostMapping("api/v1/change_priority")
    public ResponseEntity changePriority(@RequestBody ChangePriority prior){
        Priority priority = Priority.values()[prior.getPriority()];
        orderService.changePriority(prior.getName(), priority);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("api/v1/delete_order")
    public ResponseEntity deleteOrder(@RequestBody int id){
        HttpStatus httpStatus = orderService.deleteOrder(id);
        return new ResponseEntity(httpStatus);
    }

//    @GetMapping("api/v1/get_orders")
//    public List<OrderEntity> getAllOrders(){
//        return orderService.getAllOrders( );
//    }

    @GetMapping("api/v1/get_orders")
    public ResponseEntity<List<OrderDTO>> getOrders(){
//        HttpStatus httpStatus = orderService.getAllOrders();
        List<OrderEntity> orders = orderService.getAllOrders();
        List<OrderDTO> res = new ArrayList<>();
        for(OrderEntity ord : orders){
            res.add(new OrderDTO(ord.getToyName(), ord.getQuantity(), ord.getPriority(), ord.getDeadline(), ord.getStatus().toString(), ord.getId()));
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }

}
