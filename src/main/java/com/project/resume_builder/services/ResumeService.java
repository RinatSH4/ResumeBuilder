package com.project.resume_builder.services;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ResumeService {
    Resume createResume(User user, Resume resume);
    Resume getResumeById(Long resumeId);
    void deleteResumeById(Long resumeId);
    List<Resume> getResumesByUser(User user);
    Resume updateResume(Long resumeId, Resume updatedResume);
    // Другие методы сервиса
}
