package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Certification;
import com.portfoliobuilder.backend.entity.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificationRepository
        extends JpaRepository<Certification, Long> {

    List<Certification> findByPortfolio(
            Portfolio portfolio
    );
}