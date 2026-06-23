package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class ProjectRequest {

    private String title;
    private String description;
    private String githubLink;
    private String liveLink;
    private String technologies;
}
