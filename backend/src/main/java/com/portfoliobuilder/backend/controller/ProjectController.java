package com.portfoliobuilder.backend.controller;

import com.portfoliobuilder.backend.dto.ProjectRequest;
import com.portfoliobuilder.backend.entity.Project;
import com.portfoliobuilder.backend.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(
            ProjectService projectService
    ) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<String> addProject(
            @RequestBody ProjectRequest request,
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                projectService.addProject(
                        request,
                        authentication.getName()
                )
        );
    }

    @GetMapping
    public ResponseEntity<List<Project>> getProjects(
            Authentication authentication
    ) {
        return ResponseEntity.ok(
                projectService.getProjects(
                        authentication.getName()
                )
        );
    }
}