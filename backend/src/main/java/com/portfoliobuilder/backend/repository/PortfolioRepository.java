package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PortfolioRepository
        extends JpaRepository<Portfolio, Long> {

    Optional<Portfolio> findByUser(User user);
}