package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "seo_pages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeoPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String slug;

    private String title;

    @Column(length = 500)
    private String description;

    private String keywords;

    @Column(length = 5000)
    private String content;
}