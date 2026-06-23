package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.CertificationRequest;
import com.portfoliobuilder.backend.entity.Certification;
import com.portfoliobuilder.backend.service.CertificationService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin("*")
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(
            CertificationService certificationService
    ) {
        this.certificationService = certificationService;
    }

    @PostMapping
    public ResponseEntity<String> addCertification(
            @RequestBody CertificationRequest request,
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                certificationService.addCertification(
                        authentication.getName(),
                        request
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Certification>> getCertifications(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                certificationService.getCertifications(
                        authentication.getName()
                )
        );
    }
}