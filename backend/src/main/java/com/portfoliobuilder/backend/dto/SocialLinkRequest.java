package com.portfoliobuilder.backend.dto;

import lombok.Data;

@Data
public class SocialLinkRequest {

    private String github;
    private String linkedin;
    private String leetcode;
    private String hackerrank;
    private String portfolioWebsite;
    private String twitter;
}