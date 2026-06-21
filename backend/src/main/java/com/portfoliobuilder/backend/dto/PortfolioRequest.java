package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class PortfolioRequest {

    private String profession;
    private String bio;
    private String location;
    private String githubUrl;
    private String linkedinUrl;
    private String portfolioUrl;
}