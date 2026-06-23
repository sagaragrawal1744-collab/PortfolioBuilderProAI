package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.EducationRequest;
import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationService {

    private final EducationRepository educationRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public EducationService(
            EducationRepository educationRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.educationRepository = educationRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String addEducation(
            EducationRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        Education education = new Education();

        education.setDegree(request.getDegree());
        education.setCollege(request.getCollege());
        education.setUniversity(request.getUniversity());
        education.setStartYear(request.getStartYear());
        education.setEndYear(request.getEndYear());
        education.setCgpa(request.getCgpa());
        education.setPortfolio(portfolio);

        educationRepository.save(education);

        return "Education Added Successfully";
    }

    public List<Education> getEducations(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return educationRepository.findByPortfolio(portfolio);
    }
}