package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.PortfolioRequest;
import com.portfoliobuilder.backend.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin("*")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(
            PortfolioService portfolioService
    ) {
        this.portfolioService = portfolioService;
    }

    @PostMapping
    public ResponseEntity<String> createPortfolio(
            @RequestBody PortfolioRequest request,
            Authentication authentication
    ) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                portfolioService.createPortfolio(
                        request,
                        email
                )
        );
    }
}