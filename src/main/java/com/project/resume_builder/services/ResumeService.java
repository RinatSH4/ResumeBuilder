package com.project.resume_builder.services;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import org.springframework.stereotype.Service;


public interface ResumeService {
    Resume createResume(User user, Resume resume);
    Resume getResumeById(Long resumeId);
    void deleteResumeById(Long resumeId);
    // Другие методы сервиса
}
