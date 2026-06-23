package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.PortfolioRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
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

    @GetMapping("/me")
    public ResponseEntity<Portfolio> getMyPortfolio(
            Authentication authentication
    ) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                portfolioService.getMyPortfolio(email)
        );
    }

    @PutMapping
    public ResponseEntity<String> updatePortfolio(
            @RequestBody PortfolioRequest request,
            Authentication authentication
    ) {

        String email = authentication.getName();

        return ResponseEntity.ok(
                portfolioService.updatePortfolio(
                        request,
                        email
                )
        );
    }
    @DeleteMapping
public ResponseEntity<String> deletePortfolio(
        Authentication authentication
) {

    String email = authentication.getName();

    return ResponseEntity.ok(
            portfolioService.deletePortfolio(email)
    );
}
}