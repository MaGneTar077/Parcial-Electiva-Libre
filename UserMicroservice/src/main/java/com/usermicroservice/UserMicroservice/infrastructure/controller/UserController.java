package com.usermicroservice.UserMicroservice.infrastructure.controller;

import com.usermicroservice.UserMicroservice.application.service.UserService;
import com.usermicroservice.UserMicroservice.domain.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) { // Cambiamos UUID por Long
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestParam String email, @RequestParam String password) {
        return userService.login(email, password)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(401).build());
    }

    @PostMapping("/validate")
    public ResponseEntity<User> validateUser(@RequestParam Long userId) { // Cambiamos UUID por Long
        return userService.validateUser(userId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(404).build());
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestParam Long userId) { // Cambiamos UUID por Long
        userService.logout(userId);
        return ResponseEntity.noContent().build();
    }
}