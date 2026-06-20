package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class CreatePortfolioRequest {

    private String portfolioTitle;

    private String slug;

    private String themeMode;
}