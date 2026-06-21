package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.CreatePortfolioRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.service.PortfolioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@CrossOrigin(origins = "*")
public class PortfolioController {

    private final PortfolioService portfolioService;

    public PortfolioController(PortfolioService portfolioService) {
        this.portfolioService = portfolioService;
    }

    // Create Portfolio
    @PostMapping("/create")
    public ResponseEntity<Portfolio> createPortfolio(
            @RequestBody CreatePortfolioRequest request) {

        Portfolio portfolio = portfolioService.createPortfolio(request);

        return ResponseEntity.ok(portfolio);
    }
}