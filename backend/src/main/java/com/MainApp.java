package com;

import com.dto.RegistrationDTO;
import com.services.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MainApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(MainApp.class, args);
        UserService userService = applicationContext.getBean(UserService.class);


//        RegistrationDTO adminDTO = new RegistrationDTO("salesM", "sales_man");
//        String adminPassword = adminDTO.getPassword();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(adminPassword);
//        adminDTO.setPassword(encodedPassword);
//        userService.registerAsSalesManager(adminDTO);
        System.out.println(userService.findByLogin("sales"));
        System.out.println(userService.findByLogin("salesM"));
        System.out.println(userService.findByLogin("admin"));
    }
}
