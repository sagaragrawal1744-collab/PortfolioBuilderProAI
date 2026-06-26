package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResumeScanResponse {

    private int atsScore;

    private List<String> foundSkills;

    private List<String> missingSections;

    private List<String> suggestions;

    private String extractedText;
}