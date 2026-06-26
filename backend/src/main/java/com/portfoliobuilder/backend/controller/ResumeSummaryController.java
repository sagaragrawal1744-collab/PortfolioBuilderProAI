package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.SummaryRequest;
import com.portfoliobuilder.backend.dto.SummaryResponse;
import com.portfoliobuilder.backend.service.ResumeSummaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume-summary")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ResumeSummaryController {

    private final ResumeSummaryService service;

    @PostMapping("/generate")
    public SummaryResponse generate(
            @RequestBody SummaryRequest request
    ) {
        return service.generateSummary(request);
    }
}