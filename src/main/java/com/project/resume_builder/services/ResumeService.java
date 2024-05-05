package com.project.resume_builder.services;

import com.project.resume_builder.models.Resume;
import org.springframework.stereotype.Service;

@Service
public interface ResumeService {
    Resume createResume(Resume resume);
    // Другие методы сервиса
}