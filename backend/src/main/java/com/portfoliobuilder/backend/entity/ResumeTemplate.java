package com.portfoliobuilder.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "resume_templates")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String previewImage;

    private String templateType;

    private boolean premium;
}