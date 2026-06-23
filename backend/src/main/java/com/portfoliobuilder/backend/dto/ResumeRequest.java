package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class ResumeRequest {

    private String title;

    private Long templateId;
}