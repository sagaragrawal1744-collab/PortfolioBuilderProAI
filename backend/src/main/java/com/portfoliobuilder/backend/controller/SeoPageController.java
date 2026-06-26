package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.entity.SeoPage;
import com.portfoliobuilder.backend.service.SeoPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/seo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class SeoPageController {

    private final SeoPageService seoPageService;

    @PostMapping
    public SeoPage create(
            @RequestBody SeoPage page
    ) {
        return seoPageService.save(page);
    }

    @GetMapping("/{slug}")
    public SeoPage get(
            @PathVariable String slug
    ) {
        return seoPageService.getBySlug(slug);
    }
}
