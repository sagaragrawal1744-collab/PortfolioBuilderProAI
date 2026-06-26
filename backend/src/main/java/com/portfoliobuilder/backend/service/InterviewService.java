package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.InterviewQuestionDto;
import com.portfoliobuilder.backend.dto.InterviewResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {

    public InterviewResponse generate(
            String technology,
            String level
    ) {

        List<InterviewQuestionDto> questions =
                new ArrayList<>();

        questions.add(
                new InterviewQuestionDto(
                        "Explain the fundamentals of " + technology + "."
                )
        );

        questions.add(
                new InterviewQuestionDto(
                        "What projects have you built using " + technology + "?"
                )
        );

        questions.add(
                new InterviewQuestionDto(
                        "What are the advantages of " + technology + "?"
                )
        );

        questions.add(
                new InterviewQuestionDto(
                        "What are some common challenges in " + technology + "?"
                )
        );

        questions.add(
                new InterviewQuestionDto(
                        "How would you rate your " + technology + " skills as a " + level + " candidate?"
                )
        );

        return new InterviewResponse(
                questions
        );
    }
}