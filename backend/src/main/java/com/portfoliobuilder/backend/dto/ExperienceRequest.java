package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class ExperienceRequest {

    private String companyName;
    private String position;
    private String description;
    private String startDate;
    private String endDate;
    private Boolean currentlyWorking;
}