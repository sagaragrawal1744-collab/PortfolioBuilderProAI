package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResumeAnalysisResponse {

    private int atsScore;

    private int keywordMatch;

    private List<String> strengths;

    private List<String> weaknesses;

    private List<String> suggestions;
}