package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.AtsScoreResponse;
import com.portfoliobuilder.backend.entity.Portfolio;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AtsScoreService {

    public AtsScoreResponse calculateScore(
            Portfolio portfolio
    ) {

        int score = 0;

        List<String> strengths = new ArrayList<>();
        List<String> improvements = new ArrayList<>();
        List<String> missingKeywords = new ArrayList<>();

        // Name
        if (portfolio.getUser() != null
                && portfolio.getUser().getName() != null
                && !portfolio.getUser().getName().isBlank()) {

            score += 10;
            strengths.add("Professional name section");

        } else {
            improvements.add("Add your full name");
        }

        // Profession
        if (portfolio.getProfession() != null
                && !portfolio.getProfession().isBlank()) {

            score += 10;
            strengths.add("Professional title");

        } else {
            improvements.add("Add professional title");
        }

        // Bio
        if (portfolio.getBio() != null
                && !portfolio.getBio().isBlank()) {

            score += 15;
            strengths.add("Professional summary");

        } else {
            improvements.add("Add professional summary");
        }

        // Skills
        if (portfolio.getSkills() != null
                && !portfolio.getSkills().isEmpty()) {

            score += 20;
            strengths.add("Skills section");

        } else {
            improvements.add("Add technical skills");
        }

        // Projects
        if (portfolio.getProjects() != null
                && !portfolio.getProjects().isEmpty()) {

            score += 20;
            strengths.add("Projects section");

        } else {
            improvements.add("Add projects");
        }

        // Education
        if (portfolio.getEducations() != null
                && !portfolio.getEducations().isEmpty()) {

            score += 15;
            strengths.add("Education section");

        } else {
            improvements.add("Add education");
        }

        // Experience
        if (portfolio.getExperiences() != null
                && !portfolio.getExperiences().isEmpty()) {

            score += 10;
            strengths.add("Experience section");

        } else {
            improvements.add("Add internships or experience");
        }

        return new AtsScoreResponse(
                score,
                strengths,
                improvements,
                missingKeywords
        );
    }
}