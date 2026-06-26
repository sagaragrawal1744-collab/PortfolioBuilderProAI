package com.portfoliobuilder.backend.repository;

import com.portfoliobuilder.backend.entity.Faq;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FaqRepository
        extends JpaRepository<Faq, Long> {

    List<Faq> findByPage(
            String page
    );
}