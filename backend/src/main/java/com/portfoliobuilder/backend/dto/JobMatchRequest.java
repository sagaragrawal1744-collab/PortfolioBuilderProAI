package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class JobMatchRequest {

    private Long portfolioId;
    private String jobDescription;
}