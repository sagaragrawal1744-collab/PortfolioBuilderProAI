package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.entity.SeoPage;
import com.portfoliobuilder.backend.repository.SeoPageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SeoPageService {

    private final SeoPageRepository repository;

    public SeoPage save(
            SeoPage seoPage
    ) {
        return repository.save(seoPage);
    }

    public SeoPage getBySlug(
            String slug
    ) {
        return repository.findBySlug(slug)
                .orElseThrow(() ->
                        new RuntimeException(
                                "SEO Page not found"
                        ));
    }
}