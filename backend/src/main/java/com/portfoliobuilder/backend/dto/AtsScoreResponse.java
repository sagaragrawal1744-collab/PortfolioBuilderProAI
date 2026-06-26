package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class AtsScoreResponse {

    private int score;

    private List<String> strengths;

    private List<String> improvements;

    private List<String> missingKeywords;
}