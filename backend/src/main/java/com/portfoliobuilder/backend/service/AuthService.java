package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.RegisterRequest;
import com.portfoliobuilder.backend.entity.Role;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.RoleRepository;
import com.portfoliobuilder.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public String register(RegisterRequest request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return "Email already exists";
        }

        Role userRole = roleRepository.findAll()
                .stream()
                .filter(role -> role.getName().equals("USER"))
                .findFirst()
                .orElseThrow();

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(
                passwordEncoder.encode(request.getPassword())
        );

        user.setIsActive(true);
        user.setIsVerified(false);
        user.setRole(userRole);

        userRepository.save(user);

        return "User registered successfully";
    }
}