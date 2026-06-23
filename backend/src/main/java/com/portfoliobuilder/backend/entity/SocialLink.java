package com.portfoliobuilder.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "social_links")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String github;

    private String linkedin;

    private String leetcode;

    private String hackerrank;

    private String portfolioWebsite;

    private String twitter;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
}