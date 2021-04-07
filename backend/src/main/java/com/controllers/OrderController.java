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
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

//    @PostMapping("api/v1/create_order")
//    public ResponseEntity create(@RequestBody final OrderDTO orderDTO){
//        orderService.createOrder(orderDTO);
//        return new ResponseEntity(HttpStatus.CREATED);
//    }

    @PostMapping("api/v1/change_status")
    public ResponseEntity changeStatus(@RequestBody ChangeStatus changeStatus){
        OrderStatus orderStatus = OrderStatus.valueOf(changeStatus.getStatus());
        orderService.changeStatus(changeStatus.getId(), orderStatus);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
    @PostMapping("api/v1/change_priority")
    public ResponseEntity changePriority(@RequestBody ChangePriority prior){
        Priority priority = Priority.valueOf(prior.getPriority());
        orderService.changePriority(prior.getId(), priority);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    @PostMapping("api/v1/delete_order/{id}")
    public ResponseEntity deleteOrder(@PathVariable int id){
        HttpStatus httpStatus = orderService.deleteOrder(id);
        return new ResponseEntity(httpStatus);
    }
    @GetMapping("api/v1/getSalesOrders/{id}")
    public ResponseEntity<List<OrderDTO>> getSalesOrders(@PathVariable int id){
        List<OrderEntity> orders = orderService.getSalesOrders(id);
        List<OrderDTO> res = new ArrayList<>();
        for (OrderEntity o : orders){
            res.add(new OrderDTO(o.getToyName(), o.getQuantity(), o.getPriority(), o.getDeadline(), o.getStatus().toString(), o.getId(), o.getSales().getId()));
        }
        return new ResponseEntity(res, HttpStatus.OK);
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
            int id=0;
            if(ord.getSales() != null){
                id = ord.getSales().getId();
            }
            res.add(new OrderDTO(ord.getToyName(), ord.getQuantity(), ord.getPriority(), ord.getDeadline(), ord.getStatus().toString(), ord.getId(), id));
        }
        return new ResponseEntity(res, HttpStatus.OK);
    }

}
