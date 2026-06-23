package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.SocialLinkRequest;
import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.*;
import org.springframework.stereotype.Service;

@Service
public class SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public SocialLinkService(
            SocialLinkRepository socialLinkRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.socialLinkRepository = socialLinkRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String saveSocialLinks(
            SocialLinkRequest request,
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        SocialLink socialLink =
                socialLinkRepository.findByPortfolio(portfolio)
                        .orElse(new SocialLink());

        socialLink.setGithub(request.getGithub());
        socialLink.setLinkedin(request.getLinkedin());
        socialLink.setLeetcode(request.getLeetcode());
        socialLink.setHackerrank(request.getHackerrank());
        socialLink.setPortfolioWebsite(request.getPortfolioWebsite());
        socialLink.setTwitter(request.getTwitter());
        socialLink.setPortfolio(portfolio);

        socialLinkRepository.save(socialLink);

        return "Social Links Saved Successfully";
    }

    public SocialLink getSocialLinks(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return socialLinkRepository.findByPortfolio(portfolio)
                .orElse(null);
    }
}