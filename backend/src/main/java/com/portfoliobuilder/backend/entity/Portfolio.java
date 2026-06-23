package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.Data;
import jakarta.persistence.OneToOne;

import java.util.List;
@Entity
@Data
@Table(name = "portfolios")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String profession;

    private String bio;

    private String location;

    private String githubUrl;

    private String linkedinUrl;

    private String portfolioUrl;

    @OneToMany(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Skill> skills;

@OneToMany(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Project> projects;

@OneToMany(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Education> educations;

@OneToMany(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Experience> experiences;

@OneToMany(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private List<Certification> certifications;

@OneToOne(
        mappedBy = "portfolio",
        cascade = CascadeType.ALL,
        orphanRemoval = true
)
private SocialLink socialLink;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}