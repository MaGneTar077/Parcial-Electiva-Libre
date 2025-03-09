package com.usermicroservice.UserMicroservice.domain.repository;

import com.usermicroservice.UserMicroservice.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Long id); // Cambiamos UUID por Long
    List<User> findAll();
    User update(User user);
    void deleteById(Long id); // Cambiamos UUID por Long
    Optional<User> findByEmail(String email);
}