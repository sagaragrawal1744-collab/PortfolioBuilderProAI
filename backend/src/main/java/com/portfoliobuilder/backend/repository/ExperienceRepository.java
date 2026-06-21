package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository
        extends JpaRepository<Experience, Long> {

    List<Experience> findByPortfolioId(Long portfolioId);
}