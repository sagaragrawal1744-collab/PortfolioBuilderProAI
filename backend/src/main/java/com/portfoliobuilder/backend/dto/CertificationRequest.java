package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class CertificationRequest {

    private String title;
    private String organization;
    private String issueDate;
    private String credentialId;
    private String certificateUrl;
}