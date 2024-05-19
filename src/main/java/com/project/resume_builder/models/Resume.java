package com.project.resume_builder.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Resume {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setUser(User user) {
    }
    // Другие поля и методы доступа
}