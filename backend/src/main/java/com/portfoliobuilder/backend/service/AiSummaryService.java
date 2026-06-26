package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.SummaryResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AiSummaryService {

    public SummaryResponse generate(
            String profession,
            List<String> skills,
            String experience
    ) {

        String skillText =
                String.join(", ", skills);

        String summary =
                "Results-driven "
                        + profession
                        + " with experience in "
                        + skillText
                        + ". "
                        + experience
                        + ". Passionate about building scalable software solutions and continuously learning new technologies.";

        return new SummaryResponse(
                summary
        );
    }
}