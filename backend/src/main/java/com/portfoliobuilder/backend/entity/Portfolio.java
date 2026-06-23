package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}