package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.ExperienceRequest;
import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public ExperienceService(
            ExperienceRepository experienceRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.experienceRepository = experienceRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String addExperience(
            ExperienceRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        Experience experience = new Experience();

        experience.setCompanyName(request.getCompanyName());
        experience.setPosition(request.getPosition());
        experience.setDescription(request.getDescription());
        experience.setStartDate(request.getStartDate());
        experience.setEndDate(request.getEndDate());
        experience.setCurrentlyWorking(request.getCurrentlyWorking());
        experience.setPortfolio(portfolio);

        experienceRepository.save(experience);

        return "Experience Added Successfully";
    }

    public List<Experience> getExperiences(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return experienceRepository.findByPortfolio(portfolio);
    }
}