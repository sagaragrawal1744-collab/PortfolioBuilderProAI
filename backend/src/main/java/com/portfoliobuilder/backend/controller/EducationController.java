package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.EducationRequest;
import com.portfoliobuilder.backend.entity.Education;
import com.portfoliobuilder.backend.service.EducationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/educations")
@CrossOrigin("*")
public class EducationController {

    private final EducationService educationService;

    public EducationController(
            EducationService educationService
    ) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<String> addEducation(
            @RequestBody EducationRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                educationService.addEducation(
                        request,
                        authentication.getName()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Education>> getEducations(
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                educationService.getEducations(
                        authentication.getName()
                )
        );
    }
}

