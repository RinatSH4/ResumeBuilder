package com.project.resume_builder.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ElementCollection
    @CollectionTable(name = "resume_education", joinColumns = @JoinColumn(name = "resume_id"))
    private List<Education> educationList;

    @ElementCollection
    @CollectionTable(name = "resume_experience", joinColumns = @JoinColumn(name = "resume_id"))
    private List<Experience> experienceList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Другие поля и методы доступа
}