package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.RegisterRequest;
import com.portfoliobuilder.backend.entity.Role;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.RoleRepository;
import com.portfoliobuilder.backend.repository.UserRepository;

import com.portfoliobuilder.backend.dto.LoginRequest;
import com.portfoliobuilder.backend.util.JwtUtil;

import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

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
    public String login(LoginRequest request) {

    User user = userRepository
            .findByEmail(request.getEmail())
            .orElseThrow();

    if (!passwordEncoder.matches(
            request.getPassword(),
            user.getPassword())) {

        throw new RuntimeException("Invalid credentials");
    }

    return jwtUtil.generateToken(user.getEmail());
}
}