package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.RegisterRequest;
import com.portfoliobuilder.backend.service.AuthService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import com.portfoliobuilder.backend.dto.LoginRequest;
import com.portfoliobuilder.backend.dto.LoginResponse;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public String register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @PostMapping("/login")
public LoginResponse login(
        @RequestBody LoginRequest request) {

    String token = authService.login(request);

    return new LoginResponse(token);
}
}