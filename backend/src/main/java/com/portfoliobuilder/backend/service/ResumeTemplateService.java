package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.entity.*;
import org.springframework.stereotype.Service;

@Service
public class ResumeTemplateService {

    public String buildHtml(
            Portfolio portfolio,
            String templateName
    ) {

        StringBuilder html = new StringBuilder();

        html.append("""
                <!DOCTYPE html>
                <html>
                <head>
                <style>
                    body{
                        font-family: Arial, sans-serif;
                        margin:40px;
                        color:#333;
                        line-height:1.5;
                    }

                    h1{
                        margin-bottom:5px;
                    }

                    h2{
                        color:#2c3e50;
                        border-bottom:1px solid #ddd;
                        padding-bottom:5px;
                        margin-top:25px;
                    }

                    h3{
                        margin-bottom:2px;
                    }

                    p{
                        margin:3px 0;
                    }

                    ul{
                        margin-top:5px;
                    }

                    li{
                        margin-bottom:5px;
                    }
                </style>
                </head>
                <body>
                """);

        // Header
        html.append("<h1>")
                .append(portfolio.getUser().getName())
                .append("</h1>");

        if (portfolio.getProfession() != null) {
            html.append("<h3>")
                    .append(portfolio.getProfession())
                    .append("</h3>");
        }

        if (portfolio.getLocation() != null) {
            html.append("<p>")
                    .append(portfolio.getLocation())
                    .append("</p>");
        }

        if (portfolio.getUser().getEmail() != null) {
            html.append("<p>Email: ")
                    .append(portfolio.getUser().getEmail())
                    .append("</p>");
        }

        // Social Links
        SocialLink social = portfolio.getSocialLink();

        if (social != null) {

            html.append("<h2>Links</h2>");

            if (social.getGithub() != null) {
                html.append("<p>GitHub: ")
                        .append(social.getGithub())
                        .append("</p>");
            }

            if (social.getLinkedin() != null) {
                html.append("<p>LinkedIn: ")
                        .append(social.getLinkedin())
                        .append("</p>");
            }

            if (social.getLeetcode() != null) {
                html.append("<p>LeetCode: ")
                        .append(social.getLeetcode())
                        .append("</p>");
            }

            if (social.getHackerrank() != null) {
                html.append("<p>HackerRank: ")
                        .append(social.getHackerrank())
                        .append("</p>");
            }

            if (social.getPortfolioWebsite() != null) {
                html.append("<p>Portfolio: ")
                        .append(social.getPortfolioWebsite())
                        .append("</p>");
            }
        }

        // Summary
        if (portfolio.getBio() != null &&
                !portfolio.getBio().isBlank()) {

            html.append("<h2>Professional Summary</h2>");
            html.append("<p>")
                    .append(portfolio.getBio())
                    .append("</p>");
        }

        // Skills
        if (portfolio.getSkills() != null &&
                !portfolio.getSkills().isEmpty()) {

            html.append("<h2>Skills</h2>");
            html.append("<ul>");

            for (Skill skill :
                    portfolio.getSkills()) {

                html.append("<li>")
                        .append(skill.getSkillName());

                if (skill.getSkillLevel() != null) {
                    html.append(" (")
                            .append(skill.getSkillLevel())
                            .append("%)");
                }

                html.append("</li>");
            }

            html.append("</ul>");
        }

        // Projects
        if (portfolio.getProjects() != null &&
                !portfolio.getProjects().isEmpty()) {

            html.append("<h2>Projects</h2>");

            for (Project project :
                    portfolio.getProjects()) {

                html.append("<h3>")
                        .append(project.getTitle())
                        .append("</h3>");

                if (project.getDescription() != null) {
                    html.append("<p>")
                            .append(project.getDescription())
                            .append("</p>");
                }
            }
        }

        // Experience
        if (portfolio.getExperiences() != null &&
                !portfolio.getExperiences().isEmpty()) {

            html.append("<h2>Experience</h2>");

            for (Experience exp :
                    portfolio.getExperiences()) {

                html.append("<h3>")
                        .append(exp.getPosition())
                        .append("</h3>");

                html.append("<p>")
                        .append(exp.getCompanyName())
                        .append("</p>");

                html.append("<p>")
                        .append(exp.getStartDate())
                        .append(" - ");

                if (Boolean.TRUE.equals(
                        exp.getCurrentlyWorking())) {

                    html.append("Present");
                } else {

                    html.append(exp.getEndDate());
                }

                html.append("</p>");

                if (exp.getDescription() != null) {
                    html.append("<p>")
                            .append(exp.getDescription())
                            .append("</p>");
                }
            }
        }

        // Education
        if (portfolio.getEducations() != null &&
                !portfolio.getEducations().isEmpty()) {

            html.append("<h2>Education</h2>");

            for (Education edu :
                    portfolio.getEducations()) {

                html.append("<h3>")
                        .append(edu.getDegree())
                        .append("</h3>");

                if (edu.getCollege() != null) {
                    html.append("<p>")
                            .append(edu.getCollege())
                            .append("</p>");
                }

                if (edu.getUniversity() != null) {
                    html.append("<p>")
                            .append(edu.getUniversity())
                            .append("</p>");
                }

                html.append("<p>")
                        .append(edu.getStartYear())
                        .append(" - ")
                        .append(edu.getEndYear())
                        .append("</p>");

                if (edu.getCgpa() != null) {
                    html.append("<p>CGPA: ")
                            .append(edu.getCgpa())
                            .append("</p>");
                }
            }
        }

        // Certifications
        if (portfolio.getCertifications() != null &&
                !portfolio.getCertifications().isEmpty()) {

            html.append("<h2>Certifications</h2>");

            for (Certification cert :
                    portfolio.getCertifications()) {

                html.append("<h3>")
                        .append(cert.getTitle())
                        .append("</h3>");

                if (cert.getOrganization() != null) {
                    html.append("<p>")
                            .append(cert.getOrganization())
                            .append("</p>");
                }

                if (cert.getIssueDate() != null) {
                    html.append("<p>Issued: ")
                            .append(cert.getIssueDate())
                            .append("</p>");
                }

                if (cert.getCredentialId() != null) {
                    html.append("<p>Credential ID: ")
                            .append(cert.getCredentialId())
                            .append("</p>");
                }

                if (cert.getCertificateUrl() != null) {
                    html.append("<p>")
                            .append(cert.getCertificateUrl())
                            .append("</p>");
                }
            }
        }

        html.append("""
                </body>
                </html>
                """);

        return html.toString();
    }
}