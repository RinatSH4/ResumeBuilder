package com.project.resume_builder.models;


import jakarta.persistence.*;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Data
@Entity
@Table(name = "users") // Указываем имя таблицы в базе данных
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @NotBlank
    @Size(min = 6)
    @Column(name = "user_password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Resume> resumes;
}