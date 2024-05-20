package com.project.resume_builder.models;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Education {
    private String degree;
    private String university;
    private String startDate;
    private String endDate;
}
