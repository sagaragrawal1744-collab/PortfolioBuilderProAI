package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.CreatePortfolioRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PortfolioService {

    private final PortfolioRepository portfolioRepository;

    public PortfolioService(PortfolioRepository portfolioRepository) {
        this.portfolioRepository = portfolioRepository;
    }

    public Portfolio createPortfolio(CreatePortfolioRequest request) {

        Portfolio portfolio = new Portfolio();

        portfolio.setPortfolioTitle(request.getPortfolioTitle());
        portfolio.setSlug(request.getSlug());
        portfolio.setProfession(request.getProfession());
        portfolio.setBio(request.getBio());
        portfolio.setLocation(request.getLocation());
        portfolio.setThemeMode(request.getThemeMode());

        portfolio.setStatus("ACTIVE");
        portfolio.setViews(0);

        portfolio.setCreatedAt(LocalDateTime.now());
        portfolio.setUpdatedAt(LocalDateTime.now());

        return portfolioRepository.save(portfolio);
    }
}