package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.ResumeScanResponse;
import com.portfoliobuilder.backend.util.SkillDictionary;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeScannerService {

    private final KeywordExtractorService
            keywordExtractorService;

    public ResumeScanResponse analyze(
            String text
    ) {

        int score = 0;

        List<String> suggestions =
                new ArrayList<>();

        List<String> missingSections =
                new ArrayList<>();

        List<String> foundSkills =
                new ArrayList<>(
                        keywordExtractorService
                                .extractSkills(text)
                );

        // Contact Information
        if (text.contains("@")) {
            score += 10;
        } else {
            missingSections.add(
                    "Email Address"
            );
            suggestions.add(
                    "Add an email address."
            );
        }

        // Skills
        if (!foundSkills.isEmpty()) {
            score += 20;
        } else {
            missingSections.add(
                    "Skills"
            );
            suggestions.add(
                    "Add a skills section."
            );
        }

        // Education
        if (text.toLowerCase()
                .contains("education")) {

            score += 15;
        } else {
            missingSections.add(
                    "Education"
            );
            suggestions.add(
                    "Add education details."
            );
        }

        // Experience
        if (text.toLowerCase()
                .contains("experience")) {

            score += 20;
        } else {
            missingSections.add(
                    "Experience"
            );
            suggestions.add(
                    "Add internships or work experience."
            );
        }

        // Projects
        if (text.toLowerCase()
                .contains("project")) {

            score += 20;
        } else {
            missingSections.add(
                    "Projects"
            );
            suggestions.add(
                    "Add projects section."
            );
        }

        // Summary
        if (text.toLowerCase()
                .contains("summary")) {

            score += 15;
        } else {
            missingSections.add(
                    "Professional Summary"
            );
            suggestions.add(
                    "Add a professional summary."
            );
        }

        return new ResumeScanResponse(
                score,
                foundSkills,
                missingSections,
                suggestions,
                text
        );
    }
}