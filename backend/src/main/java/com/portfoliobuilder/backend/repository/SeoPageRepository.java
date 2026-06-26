package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.SeoPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeoPageRepository
        extends JpaRepository<SeoPage, Long> {

    Optional<SeoPage> findBySlug(String slug);
}