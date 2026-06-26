package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AtsSuggestionResponse {

    private int matchPercentage;
    private List<String> missingSkills;
    private List<String> suggestions;
}