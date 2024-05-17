package com.project.resume_builder.services;

import com.project.resume_builder.models.User;

public interface AuthenticationService {
    User authenticate(String username, String password);
}

