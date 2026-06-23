package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.CertificationRequest;
import com.portfoliobuilder.backend.entity.*;
import com.portfoliobuilder.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;
    private final PortfolioRepository portfolioRepository;
    private final UserRepository userRepository;

    public CertificationService(
            CertificationRepository certificationRepository,
            PortfolioRepository portfolioRepository,
            UserRepository userRepository
    ) {
        this.certificationRepository = certificationRepository;
        this.portfolioRepository = portfolioRepository;
        this.userRepository = userRepository;
    }

    public String addCertification(
            String email,
             CertificationRequest request
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        Certification certification = new Certification();

        certification.setTitle(request.getTitle());
        certification.setOrganization(request.getOrganization());
        certification.setIssueDate(request.getIssueDate());
        certification.setCredentialId(request.getCredentialId());
        certification.setCertificateUrl(request.getCertificateUrl());
        certification.setPortfolio(portfolio);

        certificationRepository.save(certification);

        return "Certification Added Successfully";
    }

    public List<Certification> getCertifications(
            String email
    ) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Portfolio portfolio = portfolioRepository.findByUser(user)
                .orElseThrow(() ->
                        new RuntimeException("Portfolio not found"));

        return certificationRepository.findByPortfolio(portfolio);
    }
}
