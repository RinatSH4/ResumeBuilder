package com.project.resume_builder.config;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;



@Data
@Entity
public class StepConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stepName;
    private String stepDescription;
    private boolean isEnabled;
}