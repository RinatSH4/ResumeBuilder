package com.project.resume_builder.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users") // Указываем имя таблицы в базе данных
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // Указываем название колонки для id
    private Long id;

    @Column(name = "user_name") // Указываем название колонки для username
    private String username;

    @Column(name = "user_password") // Указываем название колонки для password
    private String password;
    // Другие поля и методы доступа
}