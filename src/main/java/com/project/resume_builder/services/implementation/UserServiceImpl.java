package com.project.resume_builder.services.implementation;

import com.project.resume_builder.models.User;
import com.project.resume_builder.repositories.UserRepository;
import com.project.resume_builder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(Long userId) {
        // Здесь реализуем логику
        return userRepository.findById(userId).orElse(null);
    }

    @Override
    public User registerUser(User user) {
        // Здесь реализуем логику регистрации пользователя
        return userRepository.save(user);
    }
}
