package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.PortfolioRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import com.portfoliobuilder.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public PortfolioService(
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String createPortfolio(
            PortfolioRequest request,
            String email
    ) {

        User user = userRepository
                .findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        if (portfolioRepository.findByUser(user).isPresent()) {
            return "Portfolio already exists";
        }

        Portfolio portfolio = new Portfolio();

        portfolio.setProfession(request.getProfession());
        portfolio.setBio(request.getBio());
        portfolio.setLocation(request.getLocation());
        portfolio.setGithubUrl(request.getGithubUrl());
        portfolio.setLinkedinUrl(request.getLinkedinUrl());
        portfolio.setPortfolioUrl(request.getPortfolioUrl());
        portfolio.setUser(user);

        portfolioRepository.save(portfolio);

        return "Portfolio created successfully";
    }
}