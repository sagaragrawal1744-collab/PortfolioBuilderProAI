package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class CoverLetterRequest {

    private String name;
    private String jobTitle;
    private String company;
    private String skills;
    private String experience;
}
