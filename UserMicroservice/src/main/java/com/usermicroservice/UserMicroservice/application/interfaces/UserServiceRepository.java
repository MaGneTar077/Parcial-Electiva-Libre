package com.usermicroservice.UserMicroservice.application.interfaces;

import com.usermicroservice.UserMicroservice.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserServiceRepository {
    List<User> getAllUsers();
    User createUser(User user);
    User updateUser(Long id, User userDetails); // Cambiamos UUID por Long
    Optional<User> login(String email, String password);
    Optional<User> validateUser(Long userId); // Cambiamos UUID por Long
    void logout(Long userId); // Cambiamos UUID por Long
}