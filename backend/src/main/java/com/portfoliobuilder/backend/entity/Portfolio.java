package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}