package com.controllers;


import com.domain.entities.PermissionEntity;
import com.domain.entities.UserEntity;
import com.dto.RegistrationDTO;
import com.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
public class UserController {
//
    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@Valid @RequestBody final RegistrationDTO user) {
        if (userService.loginExists(user.getLogin())) {
            return new ResponseEntity<>(Collections.singletonList(userService.findByLogin("Status will come here later")),HttpStatus.ACCEPTED);
        }
        else
            return new ResponseEntity<>(Collections.singletonList("Login doesn`t exist"),
                    HttpStatus.FORBIDDEN);

    }

    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody final RegistrationDTO user) {
        if (userService.loginExists(user.getLogin())) {
            return new ResponseEntity<>(Collections.singletonList("Login already exists"),
                    HttpStatus.FORBIDDEN);
        }
        String userPassword = user.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userPassword);
        user.setPassword(encodedPassword);
        userService.registerAsSalesManager(user);
        return new ResponseEntity(HttpStatus.CREATED);
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
//    @GetMapping("/books/favorite")
//    public ResponseEntity<List<BookDTO>> getFavorites(final Principal principal) {
//        System.out.println("Books favorites ");
//        String login = principal.getName();
//        List<BookEntity> favoriteBooks = userService.findFavoriteBooks(login);
//        List<BookDTO> favoriteDTOBooks = new ArrayList<>();
//        favoriteBooks.forEach(book -> {
//            favoriteDTOBooks.add(toBookDTO(book));
//        });
//        return ResponseEntity.ok(favoriteDTOBooks);
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
