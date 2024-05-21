package com.project.resume_builder.services;

import com.project.resume_builder.models.User;
import org.springframework.stereotype.Service;


public interface UserService {
    User getUserById(Long userId);
    User registerUser(User user);
    User findByUsername(String username);
    void deleteUser(Long userId);

    // Другие методы сервиса
}
