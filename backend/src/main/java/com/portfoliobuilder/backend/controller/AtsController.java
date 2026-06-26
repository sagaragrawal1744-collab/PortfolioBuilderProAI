    package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.AtsScoreResponse;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import com.portfoliobuilder.backend.service.AtsScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ats")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AtsController {

    private final AtsScoreService atsScoreService;
    private final PortfolioRepository portfolioRepository;

    @GetMapping("/score/{id}")
    public AtsScoreResponse score(
            @PathVariable Long id
    ) {

        Portfolio portfolio =
                portfolioRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Portfolio not found"
                                ));

        return atsScoreService.calculateScore(
                portfolio
        );
    }
}