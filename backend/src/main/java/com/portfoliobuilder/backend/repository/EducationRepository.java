package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Education;
import com.portfoliobuilder.backend.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationRepository
        extends JpaRepository<Education, Long> {

    List<Education> findByPortfolio(
            Portfolio portfolio
    );
}