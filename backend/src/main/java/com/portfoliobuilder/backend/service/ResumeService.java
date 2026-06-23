package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.ResumeRequest;
import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;
    private final PortfolioRepository portfolioRepository;
    private final ResumeTemplateRepository templateRepository;

    public ResumeService(
            ResumeRepository resumeRepository,
            PortfolioRepository portfolioRepository,
            ResumeTemplateRepository templateRepository
    ) {
        this.resumeRepository = resumeRepository;
        this.portfolioRepository = portfolioRepository;
        this.templateRepository = templateRepository;
    }

    public Resume createResume(
            Long portfolioId,
            ResumeRequest request
    ) {

        Portfolio portfolio = portfolioRepository.findById(portfolioId)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        ResumeTemplate template =
                templateRepository.findById(
                        request.getTemplateId()
                ).orElseThrow(() ->
                        new RuntimeException("Template not found"));

        Resume resume = Resume.builder()
                .title(request.getTitle())
                .portfolio(portfolio)
                .template(template)
                .atsScore(0)
                .build();

        return resumeRepository.save(resume);
    }
    public byte[] generateResume(Long portfolioId) {
    return "Resume generation coming soon..."
            .getBytes();
}

    public List<Resume> getByPortfolio(Long portfolioId) {
        return resumeRepository.findByPortfolioId(portfolioId);
    }
}