package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class JobMatchResponse {

    private int matchPercentage;
    private int totalKeywords;
    private int matchedKeywords;
    private List<String> matched;
    private List<String> missing;
}