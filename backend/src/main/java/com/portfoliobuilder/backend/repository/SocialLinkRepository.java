package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SocialLinkRepository
        extends JpaRepository<SocialLink, Long> {

    Optional<SocialLink> findByPortfolio(
            Portfolio portfolio
    );
}