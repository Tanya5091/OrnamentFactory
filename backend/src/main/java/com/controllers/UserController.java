package com.controllers;


import com.domain.entities.OrderEntity;
import com.domain.entities.PermissionEntity;
import com.domain.entities.UserEntity;
import com.dto.LoginDTO;
import com.dto.OrderDTO;
import com.dto.RegistrationDTO;
import com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.h2.util.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController {
//
    private final UserService userService;

    @PostMapping("/api/v1/login")
    public HashMap<String, String> login(@Valid @RequestBody final LoginDTO user) {
        if (userService.loginExists(user.getLogin())) {

            if(userService.checkCredentials(user).isPresent()) {
                Optional<UserEntity> us = userService.findByLogin(user.getLogin());
                UserEntity usr = userService.findByLogin(us.get().getLogin()).get();
                HashMap<String, String> res = new HashMap<>();
                res.put("result", "ok");
                res.put("id", usr.getId().toString());
                res.put("role", usr.getPermissions().get(0).getPermission().toString());
                return res;
            }
            else {
                HashMap<String, String> res = new HashMap<>();
                res.put("result", "forbidden");
                res.put("message", "incorrect credentials");
                return res;
            }
        }
        else {
            HashMap<String, String> res = new HashMap<>();
            res.put("result", "forbidden");
            res.put("message", "user doesn`t exist");
            return res;
        }

    }
//@PostMapping("/api/v1/login")
////@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//public ResponseEntity login(@Valid @RequestBody final RegistrationDTO user) {
//    if (userService.loginExists(user.getLogin())) {
//        return new ResponseEntity<>(Collections.singletonList(userService.findByLogin("Status will come here later")),HttpStatus.ACCEPTED);
//    }
//    else
//        return new ResponseEntity<>(Collections.singletonList("Login doesn`t exist"),
//                HttpStatus.FORBIDDEN);
//
//}

    @PostMapping("/api/v1/register")
    public ResponseEntity register(@Valid @RequestBody final RegistrationDTO user) {
        if (userService.loginExists(user.getLogin())) {
            return new ResponseEntity<>(Collections.singletonList("Login already exists"),
                    HttpStatus.FORBIDDEN);
        }
//        String userPassword = user.getPassword();
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String encodedPassword = encoder.encode(userPassword);
//        user.setPassword(encodedPassword);
        switch (user.getPermission()){
            case "SALES_MANAGER":
                userService.registerAsSalesManager(user);
                break;
            case "MANAGER":
                userService.registerAsManager(user);
                break;
            case "FACTORY_WORKER":
                userService.registerAsFactoryWorker(user);
                break;
            default:
                return new ResponseEntity(Collections.singletonList("Incorrect role"),HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(Collections.singletonList("OK"), HttpStatus.CREATED);
    }

//    @GetMapping("/")
//    public String home(Principal principal){
//        String name = principal.getName();
//        UserEntity userEntity = userService.findByLogin(name).get();
//        List<PermissionEntity> permissionEntities = userEntity.getPermissions();
//        String permissions = "";
//        for (int i = 0; i < permissionEntities.size(); i++) {
//            permissions += permissionEntities.get(i).getPermission().toString() + " ";
//        }
//        return "Welcome, " + name + ", " + permissions;
//    }
//
//    @PreAuthorize("hasAuthority('USER')")
//    @GetMapping("/api/v1/orders")
//    public ResponseEntity<List<OrderDTO>> getUserOrders(final int id) {
//        List<OrderEntity> orders = userService.findUserOrders(id);
//        List<OrderDTO> userOrders = new ArrayList<>();
//        orders.forEach(ord -> {
//            userOrders.add(new OrderDTO(ord.getToyName(), ord.getQuantity(), ord.getPriority(), ord.getDeadline(), ord.getStatus().toString(), ord.getId()));
//        });
//        return ResponseEntity.ok(userOrders);
//    }
//
//    @PreAuthorize("hasAuthority('USER')")
//    @PutMapping("/books/favorite/add")
//    public ResponseEntity addToFavoriteBooks(final Principal principal, @RequestBody final BookEntity book) {
//        String login = principal.getName();
//        userService.addToFavorites(book, login);
//        return new ResponseEntity(HttpStatus.ACCEPTED);
//    }

}
