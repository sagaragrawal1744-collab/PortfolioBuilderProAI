package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.AtsSuggestionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AtsSuggestionService {

    private final JobMatchService jobMatchService;

    public AtsSuggestionResponse getSuggestions(
            Long portfolioId,
            String jobDescription
    ) {

        var result =
                jobMatchService.checkMatch(
                        portfolioId,
                        jobDescription
                );

        List<String> suggestions =
                new ArrayList<>();

        for (String skill :
                result.getMissing()) {

            suggestions.add(
                    "Add " + skill +
                    " to your resume or projects."
            );
        }

        return new AtsSuggestionResponse(
                result.getMatchPercentage(),
                result.getMissing(),
                suggestions
        );
    }
} 