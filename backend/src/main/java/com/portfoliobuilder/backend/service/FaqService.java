package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.entity.Faq;
import com.portfoliobuilder.backend.repository.FaqRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FaqService {

    private final FaqRepository faqRepository;

    public List<Faq> getFaqs(
            String page
    ) {
        return faqRepository.findByPage(page);
    }
}