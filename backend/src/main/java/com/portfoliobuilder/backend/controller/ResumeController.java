package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.service.ResumeService;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(
            ResumeService resumeService
    ) {
        this.resumeService = resumeService;
    }

 @GetMapping("/{portfolioId}/download")
public ResponseEntity<ByteArrayResource>
downloadResume(
        @PathVariable Long portfolioId,
        @RequestParam(defaultValue = "modern")
        String template
){
byte[] pdf =
        resumeService.generateResume(
                portfolioId,
                template
        );

        ByteArrayResource resource =
                new ByteArrayResource(pdf);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=resume.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .contentLength(pdf.length)
                .body(resource);
    }

    @GetMapping("/{portfolioId}/preview")
public ResponseEntity<ByteArrayResource>
previewResume(
        @PathVariable Long portfolioId,
        @RequestParam(defaultValue = "modern")
        String template
){

        byte[] pdf =
        resumeService.generateResume(
                portfolioId,
                template

        );

        ByteArrayResource resource =
                new ByteArrayResource(pdf);

        return ResponseEntity.ok()
                .header(
                        HttpHeaders.CONTENT_DISPOSITION,
                        "inline; filename=resume.pdf"
                )
                .contentType(
                        MediaType.APPLICATION_PDF
                )
                .contentLength(pdf.length)
                .body(resource);
    }
}