package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.AiBulletResponse;
import org.springframework.stereotype.Service;

@Service
public class AiResumeService {

    public AiBulletResponse
    generateBullet(
            String description
    ) {

        String bullet =
                "• Developed " +
                description +
                " while applying software engineering principles and problem-solving skills.";

        return new AiBulletResponse(
                bullet
        );
    }
}