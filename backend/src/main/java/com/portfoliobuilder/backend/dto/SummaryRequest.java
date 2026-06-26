package com.portfoliobuilder.backend.dto;

import lombok.Data;
import java.util.List;

@Data
public class SummaryRequest {

    private String name;
    private String profession;
    private List<String> skills;
    private String experience;

    private String tone;
}