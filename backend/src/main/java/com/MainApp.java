package com;

import com.domain.type.Priority;
import com.dto.OrderDTO;
import com.dto.RegistrationDTO;
import com.services.OrderService;
import com.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);
        UserService userService = applicationContext.getBean(UserService.class);
        OrderService orderService = applicationContext.getBean(OrderService.class);


//        RegistrationDTO adminDTO = new RegistrationDTO("salesM", "sales_man");
//        String adminPassword = adminDTO.getPassword();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(adminPassword);
//        adminDTO.setPassword(encodedPassword);
//        userService.registerAsSalesManager(adminDTO);
//        OrderDTO orderDTO = new OrderDTO("Green toy", 100, Priority.GREEN, new Date());
//        orderService.createOrder(orderDTO);

//        System.out.println(orderService.findOrderByName("TEST TOY"));
//        System.out.println(userService.findByLogin("sales"));
//        System.out.println(userService.findByLogin("salesM"));
//        System.out.println(userService.findByLogin("admin"));
//        System.out.println();
//        System.out.println(orderService.getSalesOrders(431));
    }
}
