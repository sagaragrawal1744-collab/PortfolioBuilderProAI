package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.SkillRequest;
import com.portfoliobuilder.backend.entity.Skill;
import com.portfoliobuilder.backend.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin("*")
public class SkillController {

    private final SkillService skillService;

    public SkillController(
            SkillService skillService
    ) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<String> addSkill(
            @RequestBody SkillRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                skillService.addSkill(
                        request,
                        authentication.getName()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Skill>> getSkills(
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                skillService.getSkills(
                        authentication.getName()
                )
        );
    }
}