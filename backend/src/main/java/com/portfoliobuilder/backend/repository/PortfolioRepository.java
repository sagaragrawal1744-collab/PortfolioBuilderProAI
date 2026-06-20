package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Portfolio;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PortfolioRepository
        extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByUserId(Long userId);

    Portfolio findBySlug(String slug);
}