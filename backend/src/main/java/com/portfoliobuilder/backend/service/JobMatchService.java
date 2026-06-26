package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.JobMatchResponse;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.Skill;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class JobMatchService {

    private final PortfolioRepository portfolioRepository;
    private final KeywordExtractorService keywordExtractorService;

    public JobMatchResponse checkMatch(
            Long portfolioId,
            String jobDescription
    ) {

        Portfolio portfolio =
                portfolioRepository.findById(portfolioId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Portfolio not found"
                                ));

        Set<String> jdSkills =
                keywordExtractorService
                        .extractSkills(jobDescription);

        Set<String> resumeSkills =
                new HashSet<>();

        if (portfolio.getSkills() != null) {
            for (Skill skill :
                    portfolio.getSkills()) {

                if (skill.getSkillName() != null) {
                    resumeSkills.add(
                            skill.getSkillName()
                                    .toLowerCase()
                    );
                }
            }
        }

        List<String> matched =
                new ArrayList<>();

        List<String> missing =
                new ArrayList<>();

        for (String skill :
                jdSkills) {

            if (resumeSkills.contains(skill)) {
                matched.add(skill);
            } else {
                missing.add(skill);
            }
        }

        int percentage = 0;

        if (!jdSkills.isEmpty()) {
            percentage =
                    (matched.size() * 100)
                            / jdSkills.size();
        }

        return new JobMatchResponse(
                percentage,
                jdSkills.size(),
                matched.size(),
                matched,
                missing
        );
    }
}