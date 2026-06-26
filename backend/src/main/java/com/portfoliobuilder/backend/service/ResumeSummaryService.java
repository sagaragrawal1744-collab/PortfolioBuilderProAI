package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.dto.SummaryRequest;
import com.portfoliobuilder.backend.dto.SummaryResponse;
import org.springframework.stereotype.Service;

@Service
public class ResumeSummaryService {

    public SummaryResponse generateSummary(
            SummaryRequest request
    ) {

        String skills =
                String.join(", ", request.getSkills());

        String summary;

        switch (
                request.getTone() == null
                        ? "professional"
                        : request.getTone().toLowerCase()
        ) {

            case "fresher":

                summary =
                        "Enthusiastic "
                                + request.getProfession()
                                + " with knowledge of "
                                + skills
                                + ". Passionate about learning modern technologies and building real-world applications. Seeking opportunities to apply technical skills and grow professionally.";

                break;

            case "corporate":

                summary =
                        "Results-driven "
                                + request.getProfession()
                                + " possessing expertise in "
                                + skills
                                + ". Adept at delivering scalable solutions, solving complex business problems, and collaborating effectively in professional environments.";

                break;

            case "creative":

                summary =
                        "Innovative "
                                + request.getProfession()
                                + " passionate about "
                                + skills
                                + ". Loves turning ideas into impactful digital experiences through clean design and efficient development practices.";

                break;

            case "ats":

                summary =
                        request.getProfession()
                                + " with experience in "
                                + skills
                                + ". Strong understanding of software development principles, problem-solving, and modern technologies. Proven ability to build and maintain scalable applications while continuously improving technical expertise.";

                break;

            default:

                summary =
                        "Motivated "
                                + request.getProfession()
                                + " with skills in "
                                + skills
                                + ". Passionate about developing scalable applications and continuously learning modern technologies.";

        }

        return new SummaryResponse(summary);
    }
}