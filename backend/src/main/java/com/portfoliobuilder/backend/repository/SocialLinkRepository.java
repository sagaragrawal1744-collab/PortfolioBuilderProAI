package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.SocialLink;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SocialLinkRepository
        extends JpaRepository<SocialLink, Long> {

    List<SocialLink> findByPortfolioId(Long portfolioId);
}