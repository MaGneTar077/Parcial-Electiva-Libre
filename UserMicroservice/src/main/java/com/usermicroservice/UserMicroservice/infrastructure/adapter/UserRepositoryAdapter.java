package com.usermicroservice.UserMicroservice.infrastructure.adapter;

import com.usermicroservice.UserMicroservice.domain.entity.User;
import com.usermicroservice.UserMicroservice.domain.repository.UserRepository;
import com.usermicroservice.UserMicroservice.infrastructure.entity.UserEntity;
import com.usermicroservice.UserMicroservice.infrastructure.mapper.UserMapper;
import com.usermicroservice.UserMicroservice.infrastructure.repository.SpringDataUserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    private final SpringDataUserRepository springDataUserRepository;

    public UserRepositoryAdapter(SpringDataUserRepository springDataUserRepository) {
        this.springDataUserRepository = springDataUserRepository;
    }

    @Override
    public List<User> findAll() {
        return springDataUserRepository.findAll().stream()
                .map(UserMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) { // Cambiamos UUID por Long
        return springDataUserRepository.findById(id)
                .map(UserMapper::toDomain);
    }

    @Override
    public User save(User user) {
        var userEntity = UserMapper.toEntity(user);
        return UserMapper.toDomain(springDataUserRepository.save(userEntity));
    }

    @Override
    public void deleteById(Long id) { // Cambiamos UUID por Long
        springDataUserRepository.deleteById(id);
    }

    @Override
    public User update(User user) {
        var existingUserEntity = springDataUserRepository.findById(user.getId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUserEntity.setName(user.getName());
        existingUserEntity.setLastname(user.getLastname());
        existingUserEntity.setAge(user.getAge());
        existingUserEntity.setEmail(user.getEmail());
        existingUserEntity.setPhone(user.getPhone());
        existingUserEntity.setGender(user.getGender());
        existingUserEntity.setPassword(user.getPassword());

        return UserMapper.toDomain(springDataUserRepository.save(existingUserEntity));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return springDataUserRepository.findByEmail(email)
                .map(UserMapper::toDomain);
    }
}