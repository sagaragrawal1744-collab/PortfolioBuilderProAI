package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.entity.Faq;
import com.portfoliobuilder.backend.service.FaqService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FaqController {

    private final FaqService faqService;

    @GetMapping("/{page}")
    public List<Faq> getFaqs(
            @PathVariable String page
    ) {
        return faqService.getFaqs(
                page
        );
    }
}