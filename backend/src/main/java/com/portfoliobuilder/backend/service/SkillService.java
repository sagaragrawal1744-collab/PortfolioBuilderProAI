package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.SkillRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.Skill;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import com.portfoliobuilder.backend.repository.SkillRepository;
import com.portfoliobuilder.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public SkillService(
            SkillRepository skillRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.skillRepository = skillRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String addSkill(
            SkillRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        Skill skill = new Skill();
        skill.setSkillName(request.getSkillName());
        skill.setSkillLevel(request.getSkillLevel());
        skill.setPortfolio(portfolio);

        skillRepository.save(skill);

        return "Skill Added Successfully";
    }

    public List<Skill> getSkills(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return skillRepository.findByPortfolio(portfolio);
    }
}