package com.usermicroservice.UserMicroservice.infrastructure.repository;

import com.usermicroservice.UserMicroservice.infrastructure.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpringDataUserRepository extends JpaRepository<UserEntity, Long> { // Cambiamos UUID por Long
    Optional<UserEntity> findByEmail(String email);
}