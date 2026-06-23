package com.portfoliobuilder.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "skills")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;

    private Integer skillLevel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;
}