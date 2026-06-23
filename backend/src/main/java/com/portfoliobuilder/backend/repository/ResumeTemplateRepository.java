package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.ResumeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeTemplateRepository
        extends JpaRepository<ResumeTemplate, Long> {
}