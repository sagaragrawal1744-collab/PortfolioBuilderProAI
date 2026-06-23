package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.ResumeRequest;
import com.portfoliobuilder.backend.entity.Resume;
import com.portfoliobuilder.backend.service.ResumeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/resumes")
@CrossOrigin("*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(
            ResumeService resumeService
    ) {
        this.resumeService = resumeService;
    }

    @PostMapping("/{portfolioId}")
    public Resume create(
            @PathVariable Long portfolioId,
            @RequestBody ResumeRequest request
    ) {
        return resumeService.createResume(
                portfolioId,
                request
        );
    }

    @GetMapping("/{portfolioId}")
    public List<Resume> getAll(
            @PathVariable Long portfolioId
    ) {
        return resumeService.getByPortfolio(
                portfolioId
        );
    }
}