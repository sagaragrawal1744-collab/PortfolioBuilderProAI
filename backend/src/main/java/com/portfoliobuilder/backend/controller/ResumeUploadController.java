package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.ResumeScanResponse;
import com.portfoliobuilder.backend.service.PdfParserService;
import com.portfoliobuilder.backend.service.ResumeScannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/resume")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ResumeUploadController {

    private final PdfParserService
            pdfParserService;

    private final ResumeScannerService
            resumeScannerService;

    @PostMapping("/scan")
    public ResumeScanResponse scan(
            @RequestParam("file")
            MultipartFile file
    ) {

        String text =
                pdfParserService
                        .extractText(file);

        return resumeScannerService
                .analyze(text);
    }
}