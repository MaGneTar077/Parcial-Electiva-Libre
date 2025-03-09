package com.usermicroservice.UserMicroservice.application.service;

import com.usermicroservice.UserMicroservice.application.interfaces.UserServiceRepository;
import com.usermicroservice.UserMicroservice.domain.entity.User;
import com.usermicroservice.UserMicroservice.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Service
public class UserService implements UserServiceRepository {

    private final UserRepository userRepository;
    private final ConcurrentMap<Long, User> loggedInUsers; // Cambiamos UUID por Long

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.loggedInUsers = new ConcurrentHashMap<>();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User userDetails) { // Cambiamos UUID por Long
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userDetails.getName());
        existingUser.setLastname(userDetails.getLastname());
        existingUser.setAge(userDetails.getAge());
        existingUser.setEmail(userDetails.getEmail());
        existingUser.setPhone(userDetails.getPhone());
        existingUser.setGender(userDetails.getGender());
        existingUser.setPassword(userDetails.getPassword());

        return userRepository.save(existingUser);
    }

    @Override
    public Optional<User> login(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent() && userOptional.get().getPassword().equals(password)) {
            loggedInUsers.put(userOptional.get().getId(), userOptional.get());
            System.out.println("User logged in: " + userOptional.get().getEmail());
            return userOptional;
        }
        return Optional.empty();
    }

    @Override
    public Optional<User> validateUser(Long userId) { // Cambiamos UUID por Long
        User user = loggedInUsers.get(userId);
        if (user != null) {
            System.out.println("User validated: " + user.getEmail());
        } else {
            System.out.println("User not found in session: " + userId);
        }
        return Optional.ofNullable(user);
    }

    @Override
    public void logout(Long userId) { // Cambiamos UUID por Long
        User user = loggedInUsers.remove(userId);
        if (user != null) {
            System.out.println("User logged out: " + user.getEmail());
        } else {
            System.out.println("User not found in session: " + userId);
        }
    }
}