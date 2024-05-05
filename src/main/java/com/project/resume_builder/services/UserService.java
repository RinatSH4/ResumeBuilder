package com.project.resume_builder.services;

import com.project.resume_builder.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User registerUser(User user);
    // Другие методы сервиса
}
