package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.ResumeAnalysisResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeAnalyzerService {

    private final JobMatchService jobMatchService;

    public ResumeAnalysisResponse analyze(
            Long portfolioId,
            String jobDescription
    ) {

        var match =
                jobMatchService.checkMatch(
                        portfolioId,
                        jobDescription
                );

        List<String> strengths =
                new ArrayList<>();

        List<String> weaknesses =
                new ArrayList<>();

        List<String> suggestions =
                new ArrayList<>();

        if (match.getMatchPercentage() >= 80) {
            strengths.add(
                    "Excellent keyword match."
            );
        } else {
            weaknesses.add(
                    "Low keyword match."
            );

            suggestions.add(
                    "Add missing skills from the job description."
            );
        }

        for (String skill :
                match.getMissing()) {

            suggestions.add(
                    "Add "
                            + skill
                            + " to your resume or projects."
            );
        }

        return new ResumeAnalysisResponse(
                match.getMatchPercentage(),
                match.getMatchPercentage(),
                strengths,
                weaknesses,
                suggestions
        );
    }
}