package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.SocialLinkRequest;
import com.portfoliobuilder.backend.entity.SocialLink;
import com.portfoliobuilder.backend.service.SocialLinkService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/social-links")
@CrossOrigin("*")
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    public SocialLinkController(
            SocialLinkService socialLinkService
    ) {
        this.socialLinkService = socialLinkService;
    }

    @PostMapping
    public ResponseEntity<String> saveSocialLinks(
            @RequestBody SocialLinkRequest request,
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                socialLinkService.saveSocialLinks(
                        request,
                        authentication.getName()
                )
        );
    }

    @GetMapping
    public ResponseEntity<SocialLink> getSocialLinks(
            Authentication authentication
    ) {

        return ResponseEntity.ok(
                socialLinkService.getSocialLinks(
                        authentication.getName()
                )
        );
    }
}