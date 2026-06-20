package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "portfolios")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String portfolioTitle;

    private String slug;

    private String themeMode;

    private String status;

    private Boolean isPublic;

    private Integer views;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}