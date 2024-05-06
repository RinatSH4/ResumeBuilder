package com.project.resume_builder.services.implementation;

import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.repositories.ResumeRepository;
import com.project.resume_builder.services.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeServiceImpl implements ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Override
    public Resume createResume(User user, Resume resume) {
        resume.setUser(user);
        return resumeRepository.save(resume);
    }

    @Override
    public Resume getResumeById(Long resumeId) {
        return resumeRepository.findById(resumeId)
                .orElseThrow(() -> new ResourceNotFoundException("Resume not found with id: " + resumeId));
    }

    @Override
    public void deleteResumeById(Long resumeId) {
        resumeRepository.deleteById(resumeId);
    }
}