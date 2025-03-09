package com.usermicroservice.UserMicroservice.infrastructure.mapper;

import com.usermicroservice.UserMicroservice.domain.entity.User;
import com.usermicroservice.UserMicroservice.infrastructure.entity.UserEntity;

public class UserMapper {

    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getLastname(),
                entity.getAge(),
                entity.getEmail(),
                entity.getPhone(),
                entity.getGender(),
                entity.getPassword(),
                entity.getVersion()
        );
    }

    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setLastname(user.getLastname());
        entity.setAge(user.getAge());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
        entity.setGender(user.getGender());
        entity.setPassword(user.getPassword());
        entity.setVersion(user.getVersion());
        return entity;
    }
}