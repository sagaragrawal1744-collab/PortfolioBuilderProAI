package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.ExperienceRequest;
import com.portfoliobuilder.backend.entity.Experience;
import com.portfoliobuilder.backend.service.ExperienceService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiences")
@CrossOrigin("*")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(
            ExperienceService experienceService
    ) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public ResponseEntity<String> addExperience(
            @RequestBody ExperienceRequest request,
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                experienceService.addExperience(
                        request,
                        authentication.getName()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Experience>> getExperiences(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                experienceService.getExperiences(
                        authentication.getName()
                )
        );
    }
}