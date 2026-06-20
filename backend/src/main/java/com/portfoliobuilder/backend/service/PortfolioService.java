package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.CreatePortfolioRequest;
import com.portfoliobuilder.backend.dto.PortfolioResponse;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import com.portfoliobuilder.backend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public PortfolioResponse createPortfolio(
            CreatePortfolioRequest request,
            String email) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow();

        Portfolio portfolio = new Portfolio();

        portfolio.setPortfolioTitle(
                request.getPortfolioTitle());

        portfolio.setSlug(
                request.getSlug());

        portfolio.setThemeMode(
                request.getThemeMode());

        portfolio.setStatus("DRAFT");

        portfolio.setIsPublic(false);

        portfolio.setViews(0);

        portfolio.setUser(user);

        portfolioRepository.save(portfolio);

        return new PortfolioResponse(
                portfolio.getId(),
                portfolio.getPortfolioTitle(),
                portfolio.getSlug(),
                portfolio.getThemeMode()
        );
    }
}