package com.portfoliobuilder.backend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PortfolioRequest {

    @NotBlank
    private String profession;

    private String bio;

    private String location;

    private String githubUrl;

    private String linkedinUrl;

    private String portfolioUrl;
}