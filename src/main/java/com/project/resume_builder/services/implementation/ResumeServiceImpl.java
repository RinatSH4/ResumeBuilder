package com.project.resume_builder.services.implementation;

import com.project.resume_builder.exeptions.ResourceNotFoundException;
import com.project.resume_builder.models.Resume;
import com.project.resume_builder.models.User;
import com.project.resume_builder.repositories.ResumeRepository;
import com.project.resume_builder.services.ResumeService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResumeServiceImpl implements ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeServiceImpl(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

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

    @Override
    public List<Resume> getResumesByUser(User user) {
        return resumeRepository.findByUser(user);
    }

    @Override
    public Resume updateResume(Long resumeId, Resume updatedResume) {
        Resume existingResume = getResumeById(resumeId);
        existingResume.setTitle(updatedResume.getTitle());
        existingResume.setContent(updatedResume.getContent());
        existingResume.setFirstName(updatedResume.getFirstName());
        existingResume.setLastName(updatedResume.getLastName());
        existingResume.setEmail(updatedResume.getEmail());
        existingResume.setPhone(updatedResume.getPhone());
        existingResume.setEducationList(updatedResume.getEducationList());
        existingResume.setExperienceList(updatedResume.getExperienceList());
        return resumeRepository.save(existingResume);
    }
}