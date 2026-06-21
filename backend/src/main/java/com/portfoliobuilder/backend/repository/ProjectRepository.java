package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

    List<Project> findByPortfolioId(Long portfolioId);
}
