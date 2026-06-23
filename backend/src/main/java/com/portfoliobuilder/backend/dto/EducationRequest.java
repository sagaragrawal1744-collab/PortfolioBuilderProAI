package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class EducationRequest {

    private String degree;
    private String college;
    private String university;
    private Integer startYear;
    private Integer endYear;
    private Double cgpa;
}