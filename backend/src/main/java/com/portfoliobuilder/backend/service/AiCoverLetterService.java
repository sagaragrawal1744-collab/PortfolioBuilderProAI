package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.CoverLetterResponse;
import org.springframework.stereotype.Service;

@Service
public class AiCoverLetterService {

    public CoverLetterResponse generate(
            String name,
            String jobTitle,
            String company,
            String skills,
            String experience
    ) {

        String letter =
                "Dear Hiring Manager,\n\n"

                + "I am writing to express my interest in the "
                + jobTitle
                + " position at "
                + company
                + ".\n\n"

                + "I have experience in "
                + skills
                + " and "
                + experience
                + ". I am passionate about building high-quality software solutions and continuously improving my technical skills.\n\n"

                + "I believe my technical background and enthusiasm for learning would allow me to contribute positively to your organization.\n\n"

                + "Thank you for your time and consideration. I look forward to the opportunity to discuss my application further.\n\n"

                + "Sincerely,\n"
                + name;

        return new CoverLetterResponse(
                letter
        );
    }
}