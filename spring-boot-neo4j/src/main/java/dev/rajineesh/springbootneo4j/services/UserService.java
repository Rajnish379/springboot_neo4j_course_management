package dev.rajineesh.springbootneo4j.services;

import dev.rajineesh.springbootneo4j.models.User;
import dev.rajineesh.springbootneo4j.repositories.UserRepository;

import dev.rajineesh.springbootneo4j.requests.CreateUserRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User createUser(CreateUserRequest request) {
        // TODO: make sure that this username doesn't exist.
        User user = new User();

        user.setName(request.getName());
        user.setUsername(request.getUsername());
        user.setRoles(request.getRoles());
        user.setPassword(passwordEncoder.encode(request.getPassword()));


        userRepository.save(user);

        return user;

    }
}
