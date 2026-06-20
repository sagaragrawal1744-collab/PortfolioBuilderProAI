package com.portfoliobuilder.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PortfolioResponse {

    private Long id;

    private String portfolioTitle;

    private String slug;

    private String themeMode;
}