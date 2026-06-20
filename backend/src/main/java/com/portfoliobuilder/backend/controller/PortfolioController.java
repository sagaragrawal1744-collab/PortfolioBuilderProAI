package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.CreatePortfolioRequest;
import com.portfoliobuilder.backend.dto.PortfolioResponse;
import com.portfoliobuilder.backend.service.PortfolioService;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/portfolio")
@RequiredArgsConstructor
public class PortfolioController {

    private final PortfolioService portfolioService;

    @PostMapping
    public PortfolioResponse createPortfolio(

            @RequestBody CreatePortfolioRequest request,

            Authentication authentication) {

        return portfolioService.createPortfolio(
                request,
                authentication.getName()
        );
    }
}