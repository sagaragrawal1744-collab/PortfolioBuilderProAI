package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ResumeAIService {

    private final ResumeRepository resumeRepository;

    public ResumeAIService(
            ResumeRepository resumeRepository
    ) {
        this.resumeRepository = resumeRepository;
    }

    public String generateSummary(Long resumeId) {

        Resume resume = resumeRepository.findById(resumeId)
                .orElseThrow(() ->
                        new RuntimeException("Resume not found"));

        Portfolio portfolio = resume.getPortfolio();

        String skills = portfolio.getSkills()
                .stream()
                .map(Skill::getSkillName)
                .collect(Collectors.joining(", "));

        String projects = portfolio.getProjects()
                .stream()
                .map(Project::getTitle)
                .collect(Collectors.joining(", "));

        String summary =
                "Passionate "
                        + portfolio.getProfession()
                        + " with hands-on experience in "
                        + skills
                        + ". Built real-world projects including "
                        + projects
                        + ". Strong problem-solving abilities and passion for developing scalable software solutions.";

        resume.setProfessionalSummary(summary);

        resumeRepository.save(resume);

        return summary;
    }
}