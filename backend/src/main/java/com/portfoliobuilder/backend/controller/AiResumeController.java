package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.AiBulletRequest;
import com.portfoliobuilder.backend.dto.AiBulletResponse;
import com.portfoliobuilder.backend.dto.CoverLetterRequest;
import com.portfoliobuilder.backend.dto.CoverLetterResponse;
import com.portfoliobuilder.backend.dto.InterviewRequest;
import com.portfoliobuilder.backend.dto.InterviewResponse;
import com.portfoliobuilder.backend.dto.SummaryRequest;
import com.portfoliobuilder.backend.dto.SummaryResponse;
import com.portfoliobuilder.backend.service.AiCoverLetterService;
import com.portfoliobuilder.backend.service.AiResumeService;
import com.portfoliobuilder.backend.service.AiSummaryService;
import com.portfoliobuilder.backend.service.InterviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AiResumeController {

    private final AiResumeService aiResumeService;
    private final AiSummaryService aiSummaryService;
    private final AiCoverLetterService
        aiCoverLetterService;
        private final InterviewService interviewService;

    @PostMapping("/bullet")
    public AiBulletResponse generateBullet(
            @RequestBody AiBulletRequest request
    ) {

        return aiResumeService.generateBullet(
                request.getDescription()
        );
    }

    @PostMapping("/summary")
    public SummaryResponse generateSummary(
            @RequestBody SummaryRequest request
    ) {

        return aiSummaryService.generate(
                request.getProfession(),
                request.getSkills(),
                request.getExperience()
        );
    }
    @PostMapping("/cover-letter")
public CoverLetterResponse
generateCoverLetter(
        @RequestBody
        CoverLetterRequest request
) {

    return aiCoverLetterService.generate(
            request.getName(),
            request.getJobTitle(),
            request.getCompany(),
            request.getSkills(),
            request.getExperience()
    );
}

@PostMapping("/interview")
public InterviewResponse generateInterviewQuestions(
        @RequestBody InterviewRequest request
) {

    return interviewService.generate(
            request.getTechnology(),
            request.getLevel()
    );
}
}