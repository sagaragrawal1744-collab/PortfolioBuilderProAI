package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.ProjectRequest;
import com.portfoliobuilder.backend.entity.Portfolio;
import com.portfoliobuilder.backend.entity.Project;
import com.portfoliobuilder.backend.entity.User;
import com.portfoliobuilder.backend.repository.PortfolioRepository;
import com.portfoliobuilder.backend.repository.ProjectRepository;
import com.portfoliobuilder.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public ProjectService(
            ProjectRepository projectRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.projectRepository = projectRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String addProject(
            ProjectRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        Project project = new Project();

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setGithubLink(request.getGithubLink());
        project.setLiveLink(request.getLiveLink());
        project.setTechnologies(request.getTechnologies());
        project.setPortfolio(portfolio);

        projectRepository.save(project);

        return "Project Added Successfully";
    }

    public List<Project> getProjects(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return projectRepository.findByPortfolio(portfolio);
    }
}