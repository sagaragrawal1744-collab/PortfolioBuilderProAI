package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Project;
import com.portfoliobuilder.backend.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository
        extends JpaRepository<Project, Long> {

    List<Project> findByPortfolio(
            Portfolio portfolio
    );
}