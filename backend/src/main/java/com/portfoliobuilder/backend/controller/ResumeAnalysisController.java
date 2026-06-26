package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.JobMatchRequest;
import com.portfoliobuilder.backend.dto.ResumeAnalysisResponse;
import com.portfoliobuilder.backend.service.ResumeAnalyzerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume-analysis")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ResumeAnalysisController {

    private final ResumeAnalyzerService service;

    @PostMapping
    public ResumeAnalysisResponse analyze(
            @RequestBody
            JobMatchRequest request
    ) {

        return service.analyze(
                request.getPortfolioId(),
                request.getJobDescription()
        );
    }
}