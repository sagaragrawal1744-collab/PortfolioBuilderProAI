package com.portfoliobuilder.backend.service;

import com.portfoliobuilder.backend.entity.Portfolio;
import org.springframework.stereotype.Service;

@Service
public class ResumeTemplateService {

    public String buildHtml(
            Portfolio portfolio,
            String templateName
    ) {

        return """
                <html>
                <body style='font-family:Arial;padding:40px;'>

                <h1>%s</h1>

                <h3>%s</h3>

                <p>%s</p>

                <hr/>

                <h2>Location</h2>
                <p>%s</p>

                </body>
                </html>
                """.formatted(
                portfolio.getUser().getName(),
                portfolio.getProfession(),
                portfolio.getBio(),
                portfolio.getLocation()
        );
    }
}