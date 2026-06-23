package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SkillRepository
        extends JpaRepository<Skill, Long> {

    List<Skill> findByPortfolio(
            Portfolio portfolio
    );
}