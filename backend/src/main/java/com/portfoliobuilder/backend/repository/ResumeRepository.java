package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResumeRepository
        extends JpaRepository<Resume, Long> {

    List<Resume> findByPortfolioId(Long portfolioId);
}