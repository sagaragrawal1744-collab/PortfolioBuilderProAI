package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.JobMatchRequest;
import com.portfoliobuilder.backend.dto.JobMatchResponse;
import com.portfoliobuilder.backend.service.JobMatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class JobMatchController {

    private final JobMatchService jobMatchService;

    @PostMapping("/match")
    public JobMatchResponse match(
            @RequestBody
            JobMatchRequest request
    ) {

        return jobMatchService.checkMatch(
                request.getPortfolioId(),
                request.getJobDescription()
        );
    }
}