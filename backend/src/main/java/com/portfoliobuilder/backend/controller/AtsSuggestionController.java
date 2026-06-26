package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.AtsSuggestionResponse;
import com.portfoliobuilder.backend.dto.JobMatchRequest;
import com.portfoliobuilder.backend.service.AtsSuggestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AtsSuggestionController {

    private final AtsSuggestionService
            atsSuggestionService;

    @PostMapping("/suggestions")
    public AtsSuggestionResponse suggestions(
            @RequestBody
            JobMatchRequest request
    ) {

        return atsSuggestionService.getSuggestions(
                request.getPortfolioId(),
                request.getJobDescription()
        );
    }
}