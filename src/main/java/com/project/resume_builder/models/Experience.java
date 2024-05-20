package com.project.resume_builder.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Experience {
    private String jobTitle;
    private String company;
    private String startDate;
    private String endDate;
    private String description;
}

